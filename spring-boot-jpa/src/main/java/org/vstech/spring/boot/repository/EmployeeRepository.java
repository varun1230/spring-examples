package org.vstech.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vstech.spring.boot.model.Employee;


/**
 * @author swathi varun 10/14/2018
 * 
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByName(String name);
}
