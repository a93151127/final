package com.controller.demo.service;
import com.controller.demo.domain.Customer;
import java.util.List;

public interface CustomerService {
	boolean login(Customer customer);
	  
    void register(Customer customer);//throws ServiceException;

    List<Customer> search();
}
