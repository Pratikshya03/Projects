package com.emplyoee.repository;

import java.lang.annotation.Native;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.emplyoee.model.Employee;

//to interact with database
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	
}
