package org.vstech.spring.boot.rest.controller;

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
 * By Defualt Spring Ioc all beans are Singelton which in technical means below 
 * 
 * When we create an instance of a class, we are creating an object that is residing in JVM's shared memory. 
 * Now these threads are independently executing code that operates on these instances. 
 * Each thread has a working memory, in which it keeps data from the main memory that are shared between all threads. 
 * This is where the reference to the Singleton object you have create resides. 
 * Essentially what is happening is that the byte code which was generated and is representative of the singleton object you created is being executed on each one of these threads.
 *	
 * Now the internals of how this happens is as follows:

 * Each Java virtual machine thread has a private Java virtual machine stack, created at the same time as the thread. 
 * Now, The Java virtual machine has a heap that is shared among all Java virtual machine threads. 
 * The heap is the runtime data area from which memory for all class instances and arrays is allocated. 
 * The heap is created on virtual machine start-up. When you're thread requests the singleton instance, 
 * it is going to point to a reference in the heap where the byte code for this Singleton resides. 
 * It is going to execute the appropriate code, in your case it's going to execute the first method for the first request and the second method for the second request. 
 * It's able to do this because there are no locks or restriction preventing the compiler from pointing the program counter to the area in the heap where this instance is allocated. 
 * The only restriction that the Singleton class puts on the Java Virtual Machine is that it can have only one instance in the heap of this class. That's simply it. Other than that, 
 * you can refer to it 100x times from your method, the compiler is going to point to the same byte code and simply execute it. 
 * This is why we typically want the Singleton class to be stateless, because if we any thread access it, 
 * we don't want internal variables to be mutated because of the lack of concurrency control.
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
