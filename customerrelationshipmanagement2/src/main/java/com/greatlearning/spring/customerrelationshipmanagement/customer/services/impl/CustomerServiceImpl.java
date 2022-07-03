package com.greatlearning.spring.customerrelationshipmanagement.customer.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.spring.customerrelationshipmanagement.customer.dao.CustomerDao;
import com.greatlearning.spring.customerrelationshipmanagement.customer.entity.Customer;
import com.greatlearning.spring.customerrelationshipmanagement.customer.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao dao;

	public CustomerDao getDao() {
		return dao;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		dao.save(customer);
	}

	@Override
	public Customer read(int id) {
		return dao.read(id);
	}

	@Override
	public List<Customer> readAll() {
		return dao.readAll();
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao.delete(id);
	}
		
}
