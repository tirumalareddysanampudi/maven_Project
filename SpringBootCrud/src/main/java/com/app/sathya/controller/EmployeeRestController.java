package com.app.sathya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.sathya.entity.Employee;
import com.app.sathya.service.IEmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeRestController {
	@Autowired
	private IEmployeeService service;
	
//	Note: Actually request data comimg from json format @RequestBody will convert to Object format
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		Integer id = service.saveEmploee(employee);
		return new ResponseEntity<String>("employee '"+id+"' saved",HttpStatus.OK);
	}
	@GetMapping("/all")
	public  ResponseEntity<List <Employee>> getAllEmployees()
	{
		List<Employee> list = service.getAllEmploes();
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		
}
	@GetMapping("/One/{id}")
	public ResponseEntity<Employee> getOneEmploee(@PathVariable Integer id)
	{
		Employee employee = service.getOneEmployee(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
		
	}
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		
		service.deleteEmployee(id);
		return new ResponseEntity<String>("employee '"+id+"' deleted",HttpStatus.OK);
		
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee){
		
		Employee db= service.getOneEmployee(id);
		db.setEmpId(employee.getEmpId());
		db.setEmpName(employee.getEmpName());
		db.setEmpSal(employee.getEmpSal());
		db.setEmpDept(employee.getEmpDept());
		
		service.saveEmploee(db);
		
		return new ResponseEntity<String>("employee '"+id+"' updated",HttpStatus.OK);
		
		
	}

}
