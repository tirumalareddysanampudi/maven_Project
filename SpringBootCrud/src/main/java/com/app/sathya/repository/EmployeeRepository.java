package com.app.sathya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.sathya.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
// you need not write code actually at thr time of running jpa repository will go its implenation SimplaJpaRepository class there all the method logic available
}
