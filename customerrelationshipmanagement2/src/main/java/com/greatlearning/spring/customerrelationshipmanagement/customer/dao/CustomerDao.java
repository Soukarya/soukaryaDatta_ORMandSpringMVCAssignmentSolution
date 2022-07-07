package com.greatlearning.spring.customerrelationshipmanagement.customer.dao;

import java.util.List;

import com.greatlearning.spring.customerrelationshipmanagement.customer.entity.*;

public interface CustomerDao {

	void save(Customer s);
	void delete(int id);
	Customer read(int id);
	List<Customer> readAll();
}
