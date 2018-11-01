package org.vstech.spring.boot.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vstech.spring.boot.model.Employee;
import org.vstech.spring.boot.service.EmployeeService;
import org.vstech.spring.boot.validator.EmployeeValidator;


@Controller
public class EmplyeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeValidator employeeValidator;
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("employeeForm", new Employee());
        return "emailForm";
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("employeeForm") Employee employeeForm, BindingResult bindingResult, Model model, HttpServletRequest req) {
        employeeValidator.validate(employeeForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "emailForm";
        }

        employeeService.save(employeeForm);

        req.setAttribute("empForm", employeeForm);
        
        return "redirect:/welcome";
    }
	
}
