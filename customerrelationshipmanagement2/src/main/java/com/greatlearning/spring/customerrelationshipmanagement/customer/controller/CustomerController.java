package com.greatlearning.spring.customerrelationshipmanagement.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.spring.customerrelationshipmanagement.customer.entity.Customer;
import com.greatlearning.spring.customerrelationshipmanagement.customer.services.CustomerService;

@Controller
@RequestMapping(path="customers")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	
	public CustomerService getService() {
		return service;
	}

	public void setService(CustomerService service) {
		this.service = service;
	}

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping(path="/list")
	public String listCustomers(Model model) {
		List<Customer> customers = service.readAll();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@RequestMapping(path="/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@RequestMapping(path="/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		
		Customer customer = service.read(id);
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping(path="/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName, @RequestParam(name="lastName") String lastName, @RequestParam("email") String email) {
		Customer customer;
		if(id!=0) {
			customer = service.read(id);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setEmail(email);
		}else {
			customer = new Customer(firstName,lastName,email);
		}
		service.save(customer);
		return "redirect:/customers/list";
	}
	
	@RequestMapping(path="/delete")
	public String delete(@RequestParam("customerId") int id) {
		service.delete(id);
		return "redirect:/customers/list";
	}
	
}
