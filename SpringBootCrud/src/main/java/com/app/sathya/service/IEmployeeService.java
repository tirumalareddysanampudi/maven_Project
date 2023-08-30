package com.app.sathya.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.sathya.entity.Employee;

@Repository
public interface IEmployeeService {
	
//	here I used to define my all requirements
	
	Integer saveEmploee(Employee e);
	List<Employee> getAllEmploes();
	Employee getOneEmployee(Integer id);
	void deleteEmployee(Integer id);
	void updateEmployee(Employee e);


}
