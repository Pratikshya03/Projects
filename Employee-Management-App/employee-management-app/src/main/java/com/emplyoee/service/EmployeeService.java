package com.emplyoee.service;

import com.emplyoee.model.Employee;

public interface EmployeeService {

	void saveEmployee(Employee employee);
	Iterable<Employee> findEmployees();
	Employee getEmployeeId(Long id);
	void deleteEmployee(Long id);
}
