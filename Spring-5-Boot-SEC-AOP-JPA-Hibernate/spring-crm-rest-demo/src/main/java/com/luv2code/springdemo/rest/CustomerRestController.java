package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

//# Spring REST - CRUD Database Project - Get Customers
//
//## Get Customers Overview
//
//### Application Interaction 
//
//Check Tab -> 
//
//* have a REST Client and then we'll actually have our Customer Rest Controller, that's the new code that we're creating here. They'll make a GET request as /api/customers, and then we'll return JSON, which is a list of the customers.
//
//Check Tab ->
//
//* WE'll make user of our Customer Service and our Customer DAO, and that's all from our previous MVC web project. And now acaully add this new portion on the front, our Customer REST Controller. So this is a new code we actually going to create 
//
//### Development Process
//
//1. Create Customer REST Controller
//2. Autowire CustomerService
//3. Add mapping for GET / Customers
//
//#### Step 1. Create Customer REST Controller
//
//-> File: CustomerRestController.java
//```java
//	@RestController
//	@RequestMapping("/api")
//	public class CustomerRestController {
//
//	}
//```
//
//#### Step 2. Autowire CustomerService
//
//-> File: CustomerRestController.java
//```java
//	@RestController
//	@RequestMapping("/api")
//	public class CustomerRestController {
//		
//		// autowire the CustomerService
//		@Autowired
//		private CustomerService customerService;
//
//	}
//```
//
//#### Step 3. Add mapping for GET / Customers
//
//-> File: CustomerRestController.java
//```java
//	@RestController
//	@RequestMapping("/api")
//	public class CustomerRestController {
//		
//		// autowire the CustomerService
//		@Autowired
//		private CustomerService customerService;
//
//		// add mapping for GET / Customers
//		@GetMapping("/customers")
//		public List<Customer> getCustomers() {
//			// delegate the calls to the customer service.
//			return customerService.getCustomers();
//		}
//		
//	}
//```
//
//
//## Create REST Controller
//## Testing in Postman
//## Get Single Customer Overview
//
//### Application Interaction
//Check Tab ->
//
//### Get Single Customer
//
//```java
//	// add mapping for GET /customers/{customerId}
//	@GetMapping("/customers/{customerId}")
//	public Customer getCustomer(@PathVariable int customerId){
//		Customer theCustomer = customerService.getCustomer(customerId);
//
//		return theCustomer;
//	}
//```
//
//## Get Single Customer Testing


@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET / Customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		// delegate the calls to the customer service.
		return customerService.getCustomers();
	}
	
	// add mapping for GET /customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId){
		Customer theCustomer = customerService.getCustomer(customerId);
		// Just index into the list ... keep it simple for now 
		
		// return theStudents.get(studentId);
		
		// check the studentId against list size

		if(theCustomer == null){
			throw new CustomerNotFoundException("Customer id not found - "+ customerId);
		}

		
		// If customer id is no found in db return null. And then what Jackson will do for null objects,
		// Jackson will return an empty body. 
		// We want a 404 ... if customer not found 
		// We need to refactor our code, If theCustomer is null, then throw exception
		return theCustomer;
		
		
	}
	
//	# Spring REST - CRUD Database Project - Add Customer
//
//	## Add Customer - Overview
//
//	### Application Interaction
//
//	Check Tab ->
//
//	* In our application interaction we'll actually send over a post api/customers, and in the body we'll pass over the actual customer data for first name, last name and email.  Now since new customer we're actually not passing over the ID or the primary key. we'll let the backend system generate that for us. 
//	* Our REST controller will do its work on the backend, and then will actually send back a response that'll have the customer's first name, last name and email, and will also have a new entry here for the ID. so this is ID that was automatically generated by the backend system. 
//
//
//	### Access the Request Body 
//
//	* Jackson will convert request body from JSON to POJO
//
//	* @RequestBody annotation binds the POJO to a method parameter
//
//	```java
//		@PostMapping("/customers")
//		public Customer addCustomer(@RequestBody Customer theCustomer){
//			// Now we can access the request body as a POJO, There's no need for us to parse any low level JSON here. We can access the data directly using a POJO object. 
//		}
//	```
//
//	### Add Customer
//
//	-> File: CustomerRestController.java
//	```java
//		@PostMapping("/customers")
//		public Customer addCustomer(@RequestBody Customer theCustomer){
//			// Use @RequestBody to access the request body as a POJO
//
//			theCustomer.setId(0); // what's up with Customer id?
//
//			// Delegate call to customer service
//			customerService.saveCustomer(theCustomer);
//
//			// Return updated customer object
//			return theCustomer;
//		}
//	```
//
//	#### What's up with Customer id?
//
//	* In the REST controller, we explicity set the customer id to 0
//
//	* Because our backend DAO code uses Hibernate method 
//		* session.saveOrUpdate(...)
//
//	#### Recall: CustomerDAOImpl
//
//	* they way saveOrUpdate works, i have a quick description here, basically checks the primary key. If the primary key or the id is empty, that'll perfom an insert on the new customer, else it'll perform an update on the existing customer. 
//	* So here empty means null or 0, So basically if you set the value to zero, it'll do an insert, else it'll perform an update. That's how that Hibernate method works saveOrUpdate or check the value of the primary key.
//
//	### Adding customer with HTTP POST
//
//	* If REST client is sending a request to "add", using HTTP POST
//	* Then we ignore any id sent in the request
//	* We overwrite the id with 0, to effectively set it to null/empty
//	* Then our backend DAO code will "INSERT" new customer
//
//	### Add Customer 
//
//	* ID of 0 means DAO code will "INSERT" new customer.
//	```java
//		theCustomer.setId(0);
//	```
//
//	### Sending JSON to Spring REST Controller
//
//	* When sending JSON data to Spring REST Controller
//	* For controller to process JSON data, need to set a HTTP request header
//		* Content-type: application/json
//	* Need to configure REST client to send the correct HTTP request header
//
//	### Postman - Sending JSON in Request Body
//
//	* Must set HTTP request header in Postman
//	## Add Customer - Coding

	// add mapping for POST / customers - add new customer
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer){
		// Use @RequestBody to access the request body as a POJO
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update

		theCustomer.setId(0); // what's up with Customer id?

		// Delegate call to customer service
		customerService.saveCustomer(theCustomer);

		// Return updated customer object
		return theCustomer;
	}
	
//	# Spring REST - CRUD Database Project - Update Customer
//
//	## Update Customer - Overview
//
//	### Application Interaction
//
//	* Now let's look at the application interaction between our REST client and our customer REST controller. What we'll do here is we'll use of the put method to perform and update. So we'll pass over the new updated info for the customer and we'll also specify the ID. Then the system will perform option on the backend 
//
//	### Update Customer
//
//	```java
//		// add mapping for PUT / customers - update existing customer
//		@PutMapping("/customers")
//		public Customer updateCustomer(@RequestBody Customer theCustomer){
//			customerService.saveCustomer(theCustomer);
//
//			return theCustomer;
//		}
//	```
// ## Update Customer - Coding
	
	// add mapping for PUT / customers - update existing customer
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer){
		customerService.saveCustomer(theCustomer);

		return theCustomer;
	}
	
//	# Spring REST - CRUD Database Project - Delete Customer
//
//	## Delete Customer - Overview
//
//	### Application Interaction
//
//	Check Tab -> 
//
//	* We'll send over a delete request to /api/customer/{customerId}, So on the backend, they'll do the approriate work, then they'll send back a res saying, 
//
//	### Delete Customer
//
//	```java
//		// add mapping for DELETE / Customers - delete customer
//		@DeleteMapping("/customers/{customerId}")
//		public String deleteCustomer(@PathVariable int customerId){
//			customerService.deleteCustomer(customerId);
//
//			return "Deleted customer id - "+ customerId
//		}
//	```
//
//	### Delete Customer - Refactor
//
//	-> CustomerRestController.java
//
//	```java
//		@DeleteMapping("/cus`tomers/{customerId}")
//		public String deleteCustomer(@PathVariable int customerId){
//			Customer tempCustomer = customerService.getCustomer(customerId);
//
//			// throw exception if null
//
//			if(tempCustomer == null){
//				throw new CustomerNotFoundException("Customer id not found - "+ customerId);
//			}
//			customerService.deleteCustomer(customerId);
//			return "Deleted customer id - "+ customerId;
//		}
//	```
//
//
//	## Delete Customer - Coding
//	## Delete Customer - Testing

	// # Spring REST - Securing REST API Endpoints with Spring Security
	// Check PDF
	
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId){
		Customer tempCustomer = customerService.getCustomer(customerId);

		// throw exception if null

		if(tempCustomer == null){
			throw new CustomerNotFoundException("Customer id not found - "+ customerId);
		}
		customerService.deleteCustomer(customerId);
		return "Deleted customer id - "+ customerId;
	}
}