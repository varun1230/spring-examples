package org.vstech.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vstech.spring.boot.model.Employee;
import org.vstech.spring.boot.repository.EmployeeRepository;


@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee findEmp(String empName) {
		return employeeRepository.findByName(empName);
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

}
