package org.vstech.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.vstech.spring.model.Employee;

/*
 * Usage of @Controller @Since Spring 2.5
 * 
 * 
 */
@Controller
@RequestMapping("controller")
public class UsageOfController {

	/*
	 * Example of sending string reponse
	 */
	@RequestMapping(value="printMessage")
	public @ResponseBody String printMessage() {
		System.out.println("Example of sample print message");
		return "Response from the plain controller";
	}
	
	/*
	 * Example of forward from one requestMapping to another requestMapping
	 */

	@RequestMapping(value="forwardPrintMessage") 
	public String forwardPrintMessage() {
		System.out.println("Inside the forwardPrintMessage");
		return "printMessage";
	}
	
	/*
	 * Example of sending a view back
	 */
	@RequestMapping(value="sampleMV")
	public ModelAndView getSampleMV() {
		System.out.println("Example of returning sample model and view");
		return new ModelAndView("sampleMV");
	}
	
	/*
	 * Example of returning JSON String
	 */

	@RequestMapping(value="getEmployeeInJSON/{name}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Employee getEmployeeInJSON(@PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return e;
	}
	
	
	/*
	 * Example of returning JSON String
	 */

	@RequestMapping(value="getEmployeeInXML/{name}.xml", method=RequestMethod.GET, produces="application/xml")
	public @ResponseBody Employee getEmployeeInXML(@PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return e;
	}
}
