package com.controller.demo.dao;

import java.util.List;

import com.controller.demo.domain.Customer;

public interface CustomerDao {
	void create(Customer customer);
	void modify(Customer customer);
	void remove(Customer customer);
	Customer findByPk(int pk);
	Customer findByNumber(String number);
	List<Customer> findAll();
}
