package org.vstech.spring.controller;

/*
 * https://www.genuitec.com/spring-frameworkrestcontroller-vs-controller/
 * 
 * https://www.baeldung.com/spring-requestmapping
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingRestController {

	@RequestMapping(value="/printMessage/${id}")
	public void printMessage(@RequestParam String id, HttpServletRequest request, HttpServletResponse response){	
	
	System.out.println("Request Recevied is"+id);
	}
	
}
