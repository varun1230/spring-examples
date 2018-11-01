package org.vstech.spring.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class XSSRequestWrapper extends HttpServletRequestWrapper {
private XSSProcessService xssProcessService = new XSSProcessService();
	
	private ServletInputStream inputStream = new ServletInputStream() {
		ByteArrayInputStream byteArrayInputStream = null;
		@Override
		public int read() throws IOException {
			
			if(getXSSRequestWrapperObj().getContentType() != null && getXSSRequestWrapperObj().getContentType().toLowerCase().indexOf("multipart/form-data") > -1) {
				// we will ignore multipart data for now.
				return getSuperInputStream().read();
			} else if(byteArrayInputStream == null) {
				String data = getJsonToString(getXSSRequestWrapperObj());
				boolean encoded = false;
				
				if(getHeader("application/x-www-form-urlencoded") != null) {
					encoded = true;
					data = URLDecoder.decode(data, "UTF-8");
				}
				
				String strippedData = xssProcessService.processStrip(data);
				if (encoded) {
					strippedData = URLEncoder.encode(strippedData, "UTF-8");
				}
				byteArrayInputStream = new ByteArrayInputStream(strippedData.getBytes("UTF-8"));
				return byteArrayInputStream.read();
			}
			return byteArrayInputStream.read();
		}
	};
	
	
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		return this.inputStream;
	}
	
	public XSSRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> paramMapValue = super.getParameterMap();;
		Map<String,String[]> theStrippedParams = new HashMap<String,String[]>();
    	for(String parameter: paramMapValue.keySet()) {
    		String[] values = getParameterValues(parameter);
    		theStrippedParams.put(parameter, values);
    	}
		return theStrippedParams;
	}
	
	
	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name); 
		
		if(values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = xssProcessService.processStrip(values[i]);
		}
		return encodedValues;
	}
	
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name); 
		return xssProcessService.processStrip(value);
	}
	
	
	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		return xssProcessService.processStrip(value); 
	}
	
	
	private String getJsonToString(final HttpServletRequest request) throws IOException {
		final StringBuffer buffer = new StringBuffer();
		final BufferedReader reader = request.getReader();
		String line;
		
		while((line = reader.readLine()) != null) {
			buffer.append(line);
		}
	   final String data = buffer.toString();
	   return data;
	}
	
	private ServletInputStream getSuperInputStream() throws IOException {
		return super.getInputStream();
	}
	
	private XSSRequestWrapper getXSSRequestWrapperObj() {
		return this;
	}
}
