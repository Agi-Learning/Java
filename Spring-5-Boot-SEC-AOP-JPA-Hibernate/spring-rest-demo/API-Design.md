# Spring REST - API Design Best Practices

## API Design Best Practices

### REST API Design

* For real-time projects, who will use your API? (When we building a real-time project, we need to wonder who will use our API? )
* Also, how will they use your API? (And also, we need to be aware of how will they use our API? )
* Design the API based on requirements ( We need design the api based on the requierements. )

### API Design Process

1. Review API requirement
2. Identify main resource / entity
3. Use HTTP methods to assign action on resource 

#### Step 1. Review API requirement

##### From the Boss

* Create a REST API for the Customer Relationship Management(CRM) system 
* Basically what allow us to do (REST client should be able to)
	* Get a list of customers
	* Get a single customer by id
	* Add a new customer 
	* Update a customer 
	* Delete a customer
* So effectively, we want to have full CRUD support via the REST-API

#### Step 2. Identify main resource / entity

* To identify main resource / entity, look for the most prominent "noun"
* For our project, it's "customer"
* Convention is to use plural form of resource / entity: customers "/api/customers"

#### Step 3. Use HTTP methods to assign action on resource 

HTTP methods                        CRUD Action
-
POST    							Create a new entity
GET									Read a list of entities or single entity
PUT 								Update an existing entity
DELETE 								Delete an existing entity

* So effectly about Full CRUD support by specifying the appropriate HTTP method. And this is the actual best practice that's use for real-time projects. 

### CRUD Endpoint Examples

HTTP Method 		Endpoint 				CRUD Action
-
POST 				/api/customers			Create a new Customer
GET 				/api/customers			Read a list of customers
GET 				/api/customers/{id}		Read a single customer
PUT 				/api/customers 			Update an existing customer
DELETE 				/api/customers/{id} 	Delete an existing customer

* "For POST and PUT, We will send customer data as JSON in request message body."

#### Anti-Patterns

* DO NOT DO THIS ... these are REST anti-patterns, bad practice

-> /api/customersList
-> /api/deleteCustomer
-> /api/addCustomer
-> /api/updateCustomer

* Don't include actions in the endpoint Instead, use HTTP methods to assign actions ( don't include the actions or verbs in the actual endpoint. Use the HTTP methods instead so the GET, the PUT, the POST, and the DELETE)


## API Design of Real-Time Projects(PayPal, GitHub and SalesForcea)

### More API Examples

* One the following slides, we'll look at APIs from other real-time projects 

* PayPal
* GitHub
* SalesForce

#### PayPal

* Paypal Invoicing API
	* "https://developer.paypal.com/docs/api/invoicing"

* (Using theire API, you can perform crud operations on invoices, so here to create an invoice we simply use )

##### Create draft invoice
-> POST = /v1/invoicing/invoices

##### List invoices
-> GET = /v1/invoicing/invoices

##### Show invoice details
-> GET = /v1/invoicing/invoices/{invoice_id}

##### Update invoice
-> GET = /v1/invoicing/invoices/{invoice_id}

##### Delete draft invoice
-> DELETE = /v1/invoicing/invoices/{invoice_id}

#### GitHub

* GitHub Repositories API
	* "https://developer.github.com/v3/repos/#repositories"

##### Create a new repository
-> POST /user/repos

##### List Your repositories
-> GET /user/repos

##### Delete a repository
-> DELETE /repos/:owner/:repo

##### Get a repository
-> GET /repos/:owner/:repo


#### SalesForce REST API

* So SalsesForce has a large number of API's and we'll take a look at one of them here. 

* Industries REST API
	* "https://sforce.co/2J40ALH"

##### Retrieve All Individuals
-> GET /services/apexrest/v1/individual/

##### Retrieve One Individual
-> GET /services/apexrest/v1/individual/{individual_id}

##### Create an individual
-> POST /services/apexrest/clinic01/v1/individual

##### Update an individual
-> PUT /services/apexrest/clinic01/v1/individual

* the SaleForce API is they didn't use the plural form their entity or their resource, instead of individuals they simply called it individual, singular, and that's fine it's a small minor thing. As I mentioned earlier the convention is to use plural but there's no hard requirement to do that. So different API's will do things slightly different, but overall here this follows the same pattern and the same process that we've seen so for with rest API's