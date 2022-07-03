package com.greatlearning.spring.customerrelationshipmanagement.customer.services;

import java.util.List;

import com.greatlearning.spring.customerrelationshipmanagement.customer.entity.Customer;

public interface CustomerService {

	void save(Customer customer);
	Customer read(int id);
	List<Customer> readAll();
	void delete(int id);
}
