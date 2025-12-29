# Global Exception Handling in Restful Web Services

* Hi everyone welcome to Java techie. So in this tutorial we will discuss how to handle exception in Restful web services if you are using jersey implementation. So in previous tutorial we already created 1 crowd application using their implementation. So this is what the example we created right spring rest jersey example. So let us add the exception handling logic on the same code. So instead of create a new VP let's reuse it OK. So let's get started guys so. First, to handle the exception we need to create our own custom object. Where we can mention something like error code or error message to customized our exception message, isn't it? So let's create a package to defend our own custom object to handle the error message. Something like DTO, OK. So here just create a class something called error message. Just different to. To feel something like error code and error message. So that's right private int error code. And we want message. OK. So as you added lombok dependencies we now need to write greater setter. Here we can use at the rate data annotation and we want all argument constructors. We can Add all our constructors even we want no argument constructor OK. So we created error message object where we are going to populate error code and error message. So to handle the exception we need to create our own custom exception because something like we are getting database related exception. Those exception we can delegate to our resource means our control load right? So that is why let us create one package. To define our exception. New package, so name it something like advice. It's clear. Take class something like. You can name it like. OK so based on your application business you need to name the exception name OK. Suppose you are doing some order surveys so you need to write order service exception like that we need to follow the naming convention. So as of now let us add service exception class OK. As this is my custom exception we are going to write we need to extend it from Exception even you can extend from runtime but I do not want it to be runtime exception OK so that is why I extend from Exception. Now we need to add our default constructor but from this exception itself I want to populate my error code so declare one field. Something like status? OK add the constructor here. Solets are the default constructor so that we can add our own field. This. Clinton want only though exception with string message. OK here. Let's add our own field. You can write two constructor here but better to add in one constructor so that you can easily get from the same constructor. To declare like end status code. And this the status code called down status code. This is the field I want to get it so that's why I am going to add the Gator setup. But as you added long book, let's use other data annotation. OK. So we created our custom object and we created our own exception class. Now we need to throw this exception from our resource. But if you will throw from the resource method any method then someone need to take care it right? So that's why we need to create one mapper so that whatever the exception you will throw from your resource the control will goes to that map and that mapper will delegate your error response to the postman or UI OK. So let's create a mapper here. Let's name it like Sarbis Exception Mapper. And there is a pretty different interface, something like. Hey, Cortana. Which is generic type you need to pass your exception class. Our exception class name is Service Exception isn't it? Now you need to override one method something like two response OK. In this response it will pass your exception class. You need to face those error code and error message from this exception object and you need to populate those data to your error object so that we can directly return our own message to the. You are your Postman OK. Let it ex. Let's create our error message object. Error equal to new error message. Show error.save message. Get the message from exception .get message. OK. Similarly we need to set the status quo. Error. The set error code. Get the status code from your exception class. OK. So let's write string writer to write those message. String writer. Yeah it will come from Java I OK. Name it something like Writer. OK create the object of it, then we need to pass it to the start trench to print our error. OK so X dot. Print starter is so if you observe here it is accepting one argument which is our print writer OK. So, new print writer. And we need to pass our. Right, which we created. OK so now let's return our response object. So these two line is not required if you are not going to use your generic OK. So if you are using specific to your application you can remove it. You just need to return your response object as we are going to make it generic so that it can be used for all the application OK. So I can prove you here because one. Application here. So let's return the response object. Response. So set the status here. STP * toast. Don't give something like Internal Server Error. This is what will print in your postman. This Internal server error 500 won't be popular as your error code OK. So let's let's build our response first then we will check it in our postman. So server error dot get the value. Then we need to set our entity. NTT is our error object OK. So pass it. Then set the media time. Our media type equal to application zip. Yes, OK, so type the innumer type dot. Application underscore JSON just 3. OK then. buildtheresponse.buildit. We created a response object. So why there is some murder? Let me check. Yeah, let me remove one. Semi colon, yeah. Let me zoom it. So we created our own error message then from exception we get the message and we mapped it our error object and same status code we are going to map in our error. You write this string right? Start to print all the stir trays then we set our response body OK so with Internal server error and the entity which we are going to return whenever we will face the exception and we specify the media type and then we build it OK. So now let us see. Handle the exception in our resource. So we created. All the exception related configuration now we need to handle it so. Let me add in same employee OK. Something like it. ifemployee.get name. Hey Cortana call to null or if the employee name is getting empty. That is empty. Then I want to throw some eggs else. Return the. Same method. So here what you want to throw? You want to throw our own service exception which is our custom exception. OK so tell me more. Quit message. Something like. Get the message on the lake names shouldn't be. Empty or not OK. Then pass the status quo. So let me pass the status quo something like esthetic P status dot DAD request. OK as we are throwing the exception we need to throws it. So that the next method color will be my service exception mapper who will take care about the exception delivered OK. So yeah, so throw it. So what is there? It's registered that Bad request OK, so we need to get the value as we specify it as 8. OK. So let's add for this get employee by name method because I don't think we need to add exception mapping in this method get all employees because this will just simply place all the record from database, right? So let's add for the last method, so do the code change, it will return me the Get that employee. OK now we can add here if employee is not known so let us check it for null then we can throw the exception. If employee is getting null then through this exception let me copy this we will change the content. Yeah, so or something like Employee, not form. Then pause the name made. OK so that you can verify with which name user is trying to search. Let's change this bad request to something else. Let me give something conflict OK I am going to choose the etcetera. So we did noltech, now we need to return the employee object. If there is no exception then return my employee object. OK so we added exceptional link for these two method and we created our own error message. We created our own custom exception and we created our exception map. But how server will scan this service exception map isn't it? So to scan it by jersey we need to register it in our jersey config. So let me go to config the way we registered our employee reserve. Same way we need to register our exception Macbook. OK. Class. OK so we are good now I guess. Let's run our application to verify whether this exceptional link features is working or not. So yeah, let me run from here. Let me join the console. Yeah, so this up and running on PUT 8080. Go to Postman. So this is what we tried in previous tutorial right? So let's check for the post one. In post we mentioned if the name is coming empty or null then it should throw the exception. So as of now let's test for empty. Click on send. Yeah so if you observe here we are getting our own message error code is 400 due to bad request and the message which we added. Names should not be empty or. Oh, let's check for now you should get the same OK. Click on send. Yeah name should not be emptied. OK so and another one we wrote for. Get employment right. Let me go to the Employee resource. Yeah, so let's go to the postman. This is what the API had. Some name which is not present in our database. I'm adding some random name. Click on Send. Yeah so if you observe here the error code is 409. Due to the conflict we added HDP status code and employee not form with the name. The name which we are passing here right. So we can pass some valid name something like user. Type it. Employee not form with name user. This is how you can customize your own error message OK. So the flow will be when the exceptional throw from your resource will directly go to exception map OK. Now this one this is our mapper. And this mapper will be scanned by the Jersey at the time of your application. That's why we are registering in our config class OK. So this is how we can handle exception in your Restful web services if you are using PC implementation. And the approach will be different if you are using Spring rest. So already I uploaded video on Spring rest exception handling. So if anyone interested you can check this particular tutorial so that you will have run both Spring rest and Jersey implementation exception handling approach. Yeah so that's it about this particular video guys. If anyone have any doubt or concern you can add a comment and those you not subscribed it, please go ahead and subscribe it. Don't forget to press the bell icon guys so that you won't miss any update from Java Tiki and thanks for watching this video.


🌐 Global Exception Handling in Restful Web Services (Jersey)

This guide explains how to handle exceptions in RESTful Web Services when using Jersey.
We will build on the CRUD application created previously and add custom error handling.

📌 Why Exception Handling?

When exceptions occur (e.g. missing data, DB failure), we want to:

Stop processing safely

Return a meaningful JSON error response

Avoid exposing internal system errors

So we create:

✔️ Custom Error Object
✔️ Custom Exception
✔️ Exception Mapper (Global Handler)

📁 Step 1: Create DTO Package
ErrorMessage.java
package dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private int errorCode;
    private String errorMessage;
}


This class will store our custom response when an exception occurs.

📁 Step 2: Create Custom Exception
ServiceException.java
package advice;

import lombok.Data;

@Data
public class ServiceException extends Exception {

    private int statusCode;

    public ServiceException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}


Extends Exception (not RuntimeException)

Carries message + status code

📁 Step 3: Create Exception Mapper

This class catches exceptions globally and generates custom responses.

ServiceExceptionMapper.java
package advice;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.MediaType;

import dto.ErrorMessage;

@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

    @Override
    public Response toResponse(ServiceException ex) {

        ErrorMessage error = new ErrorMessage();
        error.setErrorCode(ex.getStatusCode());
        error.setErrorMessage(ex.getMessage());

        return Response.status(ex.getStatusCode())
                .entity(error)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

⚙️ Step 4: Register Mapper in Jersey Config
RestConfig.java
@Component
public class RestConfig extends ResourceConfig {
    public RestConfig() {
        register(EmployeeResource.class);
        register(ServiceExceptionMapper.class); // register global exception handler
    }
}

🌐 Step 5: Throw Custom Exceptions in Resource
EmployeeResource.java
@POST
@Path("/save")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Employee saveEmployee(Employee employee) throws ServiceException {

    if(employee.getName() == null || employee.getName().isEmpty()) {
        throw new ServiceException("Name should not be empty or null!", 400);
    }

    return dao.save(employee);
}

Handling "Not Found" case
@GET
@Path("/get/{name}")
@Produces(MediaType.APPLICATION_JSON)
public Employee getEmployeeByName(@PathParam("name") String name) throws ServiceException {

    Employee emp = dao.findByName(name);

    if(emp == null) {
        throw new ServiceException("Employee not found with name: " + name, 409);
    }

    return emp;
}

🧪 Testing in Postman
🚫 Request with Missing Name

POST /employeeResource/save

{
  "id": 111,
  "name": "",
  "department": "Admin"
}

✔️ Response
{
  "errorCode": 400,
  "errorMessage": "Name should not be empty or null!"
}

🚫 Employee Not Found

GET /employeeResource/get/Rahul

✔️ Response
{
  "errorCode": 409,
  "errorMessage": "Employee not found with name: Rahul"
}

🔁 Flow Diagram
Resource Method → throw ServiceException → Mapper → JSON Error Response

🎉 Conclusion

With this setup:

You avoid exposing internal errors

All exceptions return meaningful JSON

The API is easier for clients to understand

👍 Works like Spring @ControllerAdvice but for Jersey

📌 Recommended Next Steps

Add validation annotations (e.g. @NotNull)

Create error codes enum for consistency

Implement logging for exceptions

If you'd like, I can also generate a downloadable .md file for you.
Just say 👉 "create file" 🚀