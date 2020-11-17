package com.controller.demo.service.imp;

import java.util.List;

import com.controller.demo.dao.CustomerDao;
import com.controller.demo.domain.Customer;
import com.controller.demo.dao.imp.CustomerDaoImpJdbc;
import com.controller.demo.service.CustomerService;

public class CustomerServiceImp implements CustomerService{
	CustomerDao customerDao = new CustomerDaoImpJdbc();
	@Override
	public boolean login(Customer customer) {
		  Customer dbCustomer =customerDao.findByPk(customer.getCompanyId());
	        if (dbCustomer != null
	                && dbCustomer.getCompanyNumber().equals(customer.getCompanyNumber())) {
	            // 登录成功
	            customer.setCompanyId(dbCustomer.getCompanyId());
	            customer.setCompanyName(dbCustomer.getCompanyName());
	            customer.setCompanyTel(dbCustomer.getCompanyTel());
	            customer.setCompanyNumber(dbCustomer.getCompanyNumber());
	            customer.setCompanyPeople(dbCustomer.getCompanyPeople());
	            customer.setCompanyAddress(dbCustomer.getCompanyAddress());
	            customer.setEmployeeId(dbCustomer.getEmployeeId());
	            customer.setEmail(dbCustomer.getEmail());
	            return true;
	        }
	        return false;
	}

	@Override
	public void register(Customer customer) {
		Customer dbCustomer = customerDao.findByNumber(customer.getCompanyNumber());

        if (dbCustomer != null) { //客户ID已经存在了
            //throw new ServiceException("客户ID: " + customer.getId() + "已经存在！");
        	System.out.println("客戶統一編號:"+customer.getCompanyNumber()+"已經存在");
        }

        // 注册开始
        customerDao.create(customer);
	}

	@Override
	public List<Customer> search() {
		List<Customer> customer=customerDao.findAll();
		return customer;
	}

}
