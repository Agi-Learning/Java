# Spring Boot with Apache Derby Embedded Database | Java Techie

* How to use it So basically Apache Derby is an in memory, or we can say, embedded database, which was introduced by apogee foundation to perform persistence or db business in our application. Because the orbit database engine is full functional relational embedded database engine. And it's supporting jtvc and sql as programming apis. It uses ibm DB2 sql syntax. Ok, so why we need in memory database whenever we have admins database? So the best use case of it whenever we are working on temporary data, which is coming from any external resource, and it is not constant, it is vary in each time. So in that case, instead of use other db, we can go for embedded database because in embedded database, data will be available until your application is up. Once your application is of all data will be clean, as it is storage in our local memory. So in such case Uh we can use in memory database or else. One more. In which case we can consider it will be more helpful if you are using it for unit test case. Normally, when you are running unit test It will hit the controller, then controller to service, and then it is again hit our own db. So think why this test data will save in my own database. Why not? I will save it in embedded custom db provided by framework itself, so that we can save our memory and will get the performance. Because every unit test case, it will not goes through and hit our own db through the entire flow controller service. So in such case also, we should go for the in memory database So let us check how we can save one. We can retrieve the data from in memory database. So let us do one example using Apache Dorbe. Let me create a spring boot application.