package com.app.sathya.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.sathya.customexception.EmployeeNoFoundException;
import com.app.sathya.entity.Employee;
import com.app.sathya.repository.EmployeeRepository;
import com.app.sathya.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	EmployeeRepository repository;

	@Override
	public Integer saveEmploee(Employee e) {
		Integer id = repository.save(e).getEmpId();
		return id;
	}

	@Override
	public List<Employee> getAllEmploes() {
		List<Employee> list = repository.findAll();
		return list;
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repository.findById(id);

		Employee emp = opt.orElseThrow(() -> new EmployeeNoFoundException("Employee not exixt"));

		/*
		 * Employee emp=null;
		 * 
		 * if(opt.isPresent()) { emp = opt.get(); }else throw new
		 * EmployeeNoFoundException("employee not exist"); {
		 * 
		 * }
		 */
		// orElseThrow it will thrown an exception or it will return employee values
		return emp;
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee emp = getOneEmployee(id);
		repository.delete(emp);

	}

	@Override
	public void updateEmployee(Employee e) {
		repository.save(e);

	}

}
