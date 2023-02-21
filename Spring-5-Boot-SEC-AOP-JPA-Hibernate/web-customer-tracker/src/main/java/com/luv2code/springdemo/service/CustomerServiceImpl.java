package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

//42. @GetMapping and @PostMapping
//
//New Annotations
//
//* @GetMapping 
//* @PostMapping
//
//Most Commonly Used HTTP Methods
//
//Method 			Description
//GET 			Requests data from given resource
//POST 			Submits data to given resource
//
//Sending Data with GET method
//
//<form action="processForm" method="GET" ...>
//	...
//</form>
//
//* Form data is added to end of URL as name / value pairs
//	* theUrl?field1=value1&field2=value2...
//
//Handing Form Submission
//
//@RequestMapping("/processForm")
//public String processForm(...) {
//	...
//}
//
//* This mapping handles ALL HTTP methods
//	* GET, POST, etc...
//
//And depending on your application struture may be fine, or you may want to be able to constrain or limit the actual methods that a given mapping supports. 
//
//Constrain the Request Mapping - GET
//
//@RequestMapping(path="/processForm", method=RequestMethod.GET)
//public String processForm(...){
//	...
//}
//
//* This mapping ONLY handles GET method
//* Any other HTTP REQUEST method will get rejected
//
//New Annotation Short-Cut
//
//@GetMapping("/processForm")
//public String processForm(...){
//	...
//}
//
//* New annotation: @GetMapping
//* This mapping ONLY handles GET method
//* Any other HTTP REQUEST method will get rejected
//
//
//Sending Data with POST method
//
//<form action="processForm" method="POST" ...>
//	...
//</form>
//
//* Form data is passed in the body of HTTP request message
//
//check tab
//
//Constrain the Request Mapping - POST
//
//@RequestMapping(path="/processForm", method=RequestMethod.POST)
//public String processForm(...){
//	...
//}
//
//* This mapping ONLY handles POST method
//* Any other HTTP REQUEST method will get rejected
//
//New Annotation : @PostMapping("/processForm")
//
//Well ... which one??
//
//GET
//* Good for debugging (because you see everything on the url)
//* Bookmark or mail URL
//* Limitations on data length
//
//POST
//* Can't bookmark or email URL
//* No limitations on data length
//* Can also send binary data (file attachment, file upload - you can make use of the POST method for that)
//
//
//Define Service annotation @Service
//
//Refactor: Add a Service Layer
//check Tab
//
//service layer between our customcontroller and our customer DAO
//
//Purpose of Service Layer
//
//* Service Facade design pattern
//* Intermediate layer for custom business logic
//* Integrate data from multiple sources (DAO/repositories)
//
//
//Integrate data Multiple Data Sources
//check tab
//
//* Say for ex for customer service, we need to pull in data about a customer from diff types of locations, So, up top we'll use the customer DAO, which gives us the basic info like firstname, lastname, email address, so on. 
//
//* We also need to get all of our sales product from our company, so i'll make use of our salses DAO, and then finally at the bottom we need to make use of the license DAO, just so we can get a list of all of the software licenses that they have for our given products. And then we'll integrate all this together so that we can give the controller a single view of all that data that we've integrated and pulled together. 
//
//Most Times - Delegetes Calls -> Custmer DAO
//
//Specialized Annotation for Services
//* Spring provides the @Service annotation
//
//check tab
//
//now spring provides add service annotation, specialized annotation of the services Now looking at the digram here we've seen some of these annotations already, 
//
//Specialized Annotation for Services
//
//* @Service applied to Service implementations
//* Spring will automatically register the Service implementation
//	* thanks to component-scanning
//
//Customer Service
//
//1. Define Service interface
//2. Define Service implementation
//	* Inject the CustomerDAO
//
//Step 1: Define Service interface
//
//public interface CustomerService {
//	public List<Customer> getCustomers();
//}
//
//Step 2: Define Service implementation
//
//@Service
//public class CustomerServiceImpl implements CustomerService {
//	
//	@Autowired
//	private CustomerDAO customerDAO;
//
//	@Transactional 
//	public List<Customer> getCustomers(){
//		...
//	}
//}
//
//we create this class CustomerServiceImpl implements CustomerService Now, note here at the top you have the @Service annotation, so basically Spring will automatically register this component, Then inject our DAO by making some Autowired so we have private CustomerDAO, And then we make use of this @Transactional So, prev we put @Transactional on our DAOs, now we're actually going to kind of refactor this and move the @Transaction to the actual implementation methods at our service layer because our service methods will basically define, begin and end before any given transaction. 
//
//Updates for the DAO implementation
//Remove the @Transactional attr, becuase we want this DAO implementation to run in the context of the transaction that was defined by those service layer. that's best practice for the DAOs and Services together. You basically let the service define the transactional layer and then the DAOs run in that same context. 

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers(); // Delegate calls to DAO
	}

}
