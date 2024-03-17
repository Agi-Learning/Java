# Monitoring and Management Microservice using Spring Boot Admin Server

* This tutorial we are going to see about spring booked admin. So basically, spring booked admin is a web application which is used for managing and monitoring our string boot application. So previously we have the concept called actuator, through which we can monitor our application in each environment. But there is no user interface available for actuator concept So that's why spring good admin came up through with providing one graphical user interface to monitor our application. So for that, we need to develop an admin server where we need to register all the client planned in the sense all the microservices, so that. we can monitor those clients in our string boot admin server So internally, behind the scene, the Magic is given by actuator spring boot actuator endpoint, like the end point we have matrix and Thread terms, environment, logging, all those will be available in that user interface which provided by the string put admin. OK, so let me show you one. Image. So this is the springboard admin server. And these are the client customer service viewers convert order service. These are the client. If you click on these details, you are able to. Monitor these customer service on the 10 point like health matrix, logging, environment, trace. What are the end point available in aptitude? Those things we can monitor this user interface. Okay. So first, let's develop the spring boot admin server