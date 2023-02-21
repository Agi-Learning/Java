package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject our customer service
	// prev directly inject DAO, to actually inject the customer service instead of DAO.
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
//	43. Add Customer
//
//	1. Update list-customer.js
//		1. New "Add Customer" button
//	2. Create HTML form for new Customer
//	3. Process Form Data
//		1. Controller -> Service -> DAO
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	
//	44. Update Customer
//
//	* Each row has an Update link
//		- Current customer id embedded in link
//
//	* When clicked
//		- will load the customer from database
//		- prepopulated the form
//
//	1. Update list-customer.jsp
//		1. New "Update" link
//	2. Create customer-form.jsp
//		1. Prepopulate the form
//	3. Process form data
//		1. Controller -> Service -> DAO
//
//
//	prepopulate data firstNam, ... in the customer jsp 
//	When form is loaded, Spring MVC will call:
//	customer.getFirstName();
//	customer.getLastName();
//
//	When form is subimitter, Spring MVC will call:
//	customer.setFirstName();
//	customer.setLastName();
//
//
//	2 ways the adding data to the database, They have a session.save() that will actually perfom a new insert into the database they also have session.update() that will perform a update stuff 
//
//	saveOrUpdate(...)
//
//	if(primaryKey / id) empty
//	then INSERT new customer 
//	else  UPDATE existing customer

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
}











