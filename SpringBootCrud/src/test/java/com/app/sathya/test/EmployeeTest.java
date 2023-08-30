package com.app.sathya.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.sathya.controller.EmployeeRestController;
import com.app.sathya.entity.Employee;
import com.app.sathya.service.IEmployeeService;
import com.app.sathya.serviceimpl.EmployeeServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeTest{
	
     @Autowired
	EmployeeRestController restcontroller;
	
	@Mock
	EmployeeServiceImpl serviceimpl;
	@Mock
	IEmployeeService service;
	
	
	Employee emp;
	
	List<Employee> al;
	
	@Before
	public void setUp()
	{
		System.out.println("1");
		emp = new Employee(1,"venkey'",2300.00,"qa");
		al = new ArrayList<Employee>();
		al.add(emp);
	}
	
	@Test
	public void saveEmployeeTest()
	{
		System.out.println("2");
		//when(service.saveEmploee(emp)).thenReturn(1);
		Mockito.when(service.saveEmploee(Mockito.any())).thenReturn(1);
		Integer saveEmployee = serviceimpl.saveEmploee(emp);
		
		assertEquals("", saveEmployee);
		
	}
	
	@Test
	public void getOneemployeeTest()
	{
		//when(service.getOneEmployee(1)).thenReturn(emp);
		
	}
	/*@Test
	public void getAllEmployeeTest()
	{
		when(service.getAllEmploes()).thenReturn()
		assertEquals(1, 1);
		
	}*/
	
	

}
