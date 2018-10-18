package org.vstech.spring.boot.service;

import org.vstech.spring.boot.model.Employee;

public interface EmployeeService {
	Employee findEmp(String empName);
	
	Employee findById(long id);
	
	void save(Employee employee);
}
