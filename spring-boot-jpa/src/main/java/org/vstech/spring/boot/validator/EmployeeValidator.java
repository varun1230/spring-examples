package org.vstech.spring.boot.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.vstech.spring.boot.model.Employee;
import org.vstech.spring.boot.repository.EmployeeRepository;
import org.vstech.spring.boot.service.EmployeeService;


@Component
public class EmployeeValidator implements Validator {

	@Autowired
	private EmployeeService employeeService; 
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Employee employee = (Employee) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		
		if(employee.getName().length() < 6 || employee.getName().length() > 64){
			errors.rejectValue("name", "Size.employeeForm.name");
		}
		if(employeeService.findEmp(employee.getName()) != null) {
			errors.rejectValue("name", "Duplicate.employeeForm.name");
		}
		
	}

}
