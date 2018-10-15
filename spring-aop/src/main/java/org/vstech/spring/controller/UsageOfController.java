<<<<<<< HEAD
package org.vstech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public @ResponseBody String printMessage( HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Example of sample print message");
		return "Response from the plain controller";
	}
	
	/*
	 * Example of forward from one requestMapping to another requestMapping
	 */

	@RequestMapping(value="forwardPrintMessage") 
	public String forwardPrintMessage(@RequestParam("id") String id) {
		System.out.println("Inside the forwardPrintMessage"+id);
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
	public @ResponseBody Employee getEmployeeInJSON(HttpServletRequest request, HttpServletResponse response, @PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return e;
	}
	
	
	/*
	 * Example of returning JSON String
	 */

	@RequestMapping(value="getEmployeeInXML/{name}.xml", method=RequestMethod.GET, produces="application/xml")
	public @ResponseBody Employee getEmployeeInXML(HttpServletRequest request, HttpServletResponse response,@PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return e;
	}
}
=======
package org.vstech.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public @ResponseBody String printMessage( HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Example of sample print message");
		return "Response from the plain controller";
	}
	
	/*
	 * Example of forward from one requestMapping to another requestMapping
	 */

	@RequestMapping(value="forwardPrintMessage") 
	public String forwardPrintMessage(@RequestParam("id") String id) {
		System.out.println("Inside the forwardPrintMessage"+id);
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
	public @ResponseBody Employee getEmployeeInJSON(HttpServletRequest request, HttpServletResponse response, @PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return e;
	}
	
	
	/*
	 * Example of returning JSON String
	 */

	@RequestMapping(value="getEmployeeInXML/{name}.xml", method=RequestMethod.GET, produces="application/xml")
	public @ResponseBody Employee getEmployeeInXML(HttpServletRequest request, HttpServletResponse response,@PathVariable String name) {
		Employee e = new Employee();
		e.setName(name);
		e.setEmail(name+"@vstTech.com");
		return e;
	}
}
>>>>>>> branch 'master' of https://github.com/varun1230/spring-examples.git
