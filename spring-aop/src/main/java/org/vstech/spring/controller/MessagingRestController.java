package org.vstech.spring.controller;

/*
 * https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
 * 
 * https://www.baeldung.com/spring-requestmapping
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingRestController {

	@RequestMapping(value="/printMessage" , method=RequestMethod.GET)
//	public String printMessage(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){	
	public String printMessage(@RequestParam String id){	
		
		return "Some thing to print as the response";
	}
	
}
