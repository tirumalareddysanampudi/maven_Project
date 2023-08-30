package com.app.sathya.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.sathya.entity.Employee;

@RestController
@RequestMapping
public class EmployeeRestController {
	@Autowired
	RestTemplate resttemplate;

	private final String URI_GetOne = " http://localhost:8989/employees/One/{id}";
	private final String URI_GetAll = " http://localhost:8989/employees/all";
	@GetMapping("/v1/Onerest/{id}")
	public ResponseEntity<String> saveEmployee(@PathVariable Integer id) {
		Map<String, String> params = new HashMap<>();
		params.put("id", String.valueOf(id));
		resttemplate.getForObject(URI_GetOne, Employee.class, params);
		return new ResponseEntity<String>("employee '" + id + "' saved", HttpStatus.OK);
	}
//	@GetMapping("/v1/Onerest/all")
	//public ResponseEntity<List<Employee>> geAllEmployees() {
		
	//	ResponseEntity<List<Employee>> list = resttemplate.getForEntity(URI_GetAll , List<Employee>.class);
	//	return new ResponseEntity <List<Employee>>(list, HttpStatus.OK);
	}

