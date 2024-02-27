
# Spring REST - Overview

* Create REST APIs / Web Services with Spring
* Discuss REST concepts, JSON and HTTP messaging
* Install REST client tool: Postman
* Develop REST APIs / Web Services with @ RestController
* Build a CRUD interface to the database with Spring REST

## What are REST Web Services

### Business Problem

* Build a client app that provides the weather report for a city
* Need to get weather data from and external service 

### Application Architecture

Check Tab -> 

#### Question
* How will we connect to the Weather Service?
* What programming language do we use?
* What is the data format? (CSV, XML, some other)

#### Answers
* How will we connect to the Weather Service?
	* We can make REST API calls over HTTP
	* REST: REpresentational State Transfer
	* Lightweight approach for communicating between applications
* What programming language do we use?
	* REST is language independent
	* The client application can use ANY programming language 
	* The server application can use ANY programming language 

( So it's totally up to you as far as which language that you'll use for your application. And this is actually, a really good thing because this is gives us flexibility on the actual implementation on the client's side, and also on the server's side.)

* What is the data format?
	* REST application can use any data format
	* Commonly see XML and JSON
	* JSON is most popular and modern
		* JavaScript Object Notation
* Possible Solution
	* Use free Weather Service provided by: openweathermap.org
	* So they basically have a weather API that you can use. They give you documentation how to use it, and it's also free, that you can use as a developer. And they give you X number of queries, and so on that you can make. the data is available in JSON, XML, or HTML format.

### Call Weather Service

* The API documentation gives us the following:
	* Pass in the city name

```bash
	api.openweathermap.org/data/2.5/weather?q={city name}
	or
	api.openweathermap.org/data/2.5/weather?q={city name},{country code}
```	
 * And then you'll actually get the weather report. 

### Response - Weather Report

Check Tab ->

 * The Weather Service responds with JSON

 ```json
 	{
 		...
 		"temp": 14,
 		"temp_min": 11,
 		"temp_max": 17,
 		"humidity": 81,
 		"name": "London",
 		...
 		// Condensed version
 	}
 ```

Check Tab ->

* Name Value pairs an applications process string, and then process on it accordingly. approach with this REST API or REST web service is that this weather service that was developed by that one group: Open Weather Map, they simply provide the data feed so they're the external service, and then you can have different types of clients that can access it so, I could maybe create a client application using Spring MVC, Java, accessing this application, or I could make use of maybe a C# application, talking to this weather service, and also maybe I could maybe build an iPhone app using Swift, communicating with this weather service

Remember:
* REST calls can be made over HTTP
* REST is language independent


### Currency Converter App

Check Tab ->

* We could also create a currency converter app, right? So we have this currency app, We have this currency service, and so then I could say I need to convert US dollars to Indian rupee. You pass over the amount and then this application will actually respond with the actual value. 

### Movie Tickets App

Check Tab ->

* My Movie App and then there's some external service that gives your info about movie tickets in your area. I have given moview at a given location for a certain time, and then they'll respond with a list of movie results. And so then you can go through and choose, I'll choose this theater over here, But again the movie ticket service they're saying hey, we're simply passing back the data. You can use any programming language, any type of app or platform to process and render those results.


### Customer Relationship Manager (CRM) App

Check Tab ->

* Customer Relationship Manager, the CRM app. So we have a CRM app and then we have a CRM service. So basically they can access the list of customers by saying, get the customers, and then we'll actually send back that list of customers, So instead of doing it directly in the HTML page or JSP page or web page, we're simply going to pass back this JSON data, or this whatever data format we choose, and then the CRM app can render it accordingly. So it could be a web app, it could be a mobile app, or any other type of application there. And so we'll actually create this code for this server in this course. So we'll actually create a CRM service that's going to pass back customer data as JSON, and we'll actually write all the code for that from scratch, Propbably thinking about well who would ever send back customer data via a REST service?  
* Salseforce is huge company they actually have a huge platform based on CRM. And they also have a REST API for providing customer data from a given application. There's a very good use case for doing this, so we gonna build up for our CRM application. 

#### Where to Find REST APIs

```url
	www.progrmmableweb.com
```

* Where can I find other REST APIs or REST web services like that weather service or maybe the Salesforce service, where can i find out about it? Simply go to programmableweb.com they have nice websites you can search for given APIs, so like movies or weather or books or sports tickets or whatever, and then they'll give you a list of APIs. Some of them are free and some of them are paid. 


### What do we call it?

Check Tab ->

* So generally they all mean the same thing. All right, basically you're building an API, you're building a service, and you're providing an in point, and you're providing data based on inputs or requests and so on. So that's the big idea is that they're really all the same. 