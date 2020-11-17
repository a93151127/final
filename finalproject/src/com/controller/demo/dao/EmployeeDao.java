package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Employee;

public interface EmployeeDao {
	void create(Employee employee);
	void modify(Employee employee);
	void remove(int employeeId);
	Employee findByPk(int pk);
	
	List<Employee> findAll();
}
