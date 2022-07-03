package com.greatlearning.spring.customerrelationshipmanagement.customer.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.spring.customerrelationshipmanagement.customer.dao.CustomerDao;
import com.greatlearning.spring.customerrelationshipmanagement.customer.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory factory;
	
	private Session session;
	
	@Autowired
	public CustomerDaoImpl(SessionFactory factory){
		this.factory = factory;
		
		if(this.factory != null) {
			try {
				this.session = factory.getCurrentSession();
			}catch(HibernateException e) {
				this.session = factory.openSession();
			}
		}
	}

	@Override
	public void save(Customer s) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(s);
		tx.commit();
	}

	@Override
	public void delete(int id) {
		Transaction tx = session.beginTransaction();
		Customer temp = session.get(Customer.class, id);
		session.delete(temp);
		tx.commit();
	}

	@Override
	public Customer read(int id) {
		Customer customer = (Customer) session.get(Customer.class,id);
		return customer;
	}

	@Override
	public List<Customer> readAll() {
		List<Customer> customers = session.createQuery("from Customer",Customer.class).list();
		return customers;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
