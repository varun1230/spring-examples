package org.vstech.spring.boot.rest.controller;

/*
 * Usage of Spring @RestController @Since Spring 4.0
 * 
 * The RestController is a special controller used in Rest full webservice and the equivalent of @Controller and @ResponseBody
 * 
 * RestController annotation indicates that the class is a controller where @RequestMapping method assumes @ResponseBody by default
 * 
 * The @Controller is a specialization of @Component annotation while @RestController is a specialization of @Controller annotation 
 * 
 * It is a convenience controller annotated with @Controller and @ResponseBody 
 * 
 * One of the key difference between @Controller and @RestController then every method is written as domain object instead of view 
 * 
 * 
 * 
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vstech.spring.boot.model.Employee;



@RestController
@RequestMapping("/restController")
public class UsageOfRestController {
//	public String printMessage(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response){	
	@RequestMapping(value="/printMessage" )
	public ResponseEntity<String> printMessage(@RequestParam String id, HttpServletRequest request, HttpServletResponse response){	
		System.out.println("Example of RestController sending the response data as string");
		return new ResponseEntity<String>("Some thing to print as the response", HttpStatus.OK);
	}
	
	//TODO: Example of sending JSON String
	/*
	 * Example of returning JSON String
	 */

	@RequestMapping(value="/getEmployeeInJSON/{name}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<Employee> getEmployeeInJSON(@PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}
	
	
	/*
	 * Example of returning JSON String
	 */

	@RequestMapping(value="/getEmployeeInXML/{name}.xml", method=RequestMethod.GET, produces="application/xml")
	public @ResponseBody Employee getEmployeeInXML(@PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return e;
	}
	//TODO: Example of returning view
}
