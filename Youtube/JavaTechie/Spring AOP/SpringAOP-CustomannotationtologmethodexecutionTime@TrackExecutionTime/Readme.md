# Spring AOP - Custom annotation to log method execution Time | @TrackExecutionTime

* As a developer we need to focus on performance of our code. Means I should always expect the piece of code which I wrote should give faster response. Let's say I have a method who is doing some complex business. So I want to evaluate how much time this method is taking to execute. Let's consider this example. I have the product service, so at the time of application load I am creating 10000 product object and I am persisting them in database. And I have a method called find all product. We'll create list of product object from database. So here I want to track execution time for this kind of product method. I want to know how much time this method is taking to complete its execution. I can do this. So this is very simple approach which people are following. What you can do? We will use system dot current time millisecond. So let us write long start. timeequaltosystem.getting. SDA jobs abroad is easy passport renewal. Current time millisecond so I will write system dot current time millisecond before and after method call. So what you can do? Let's complete paste this. Let's add it here. Insert to end time. OK and here instead of written you can write list of product. OK and at 10 we can return or we can print the value for this end time. Start time. So this this particular recipe lane where we are subtracting end time with our start time will give the actual result actual millisecond it will give so that we will get to know how much time this particular method is taking to execute. So this will work no doubt. But if same kind of track execution time I want in each and every method or let's say this is in service, I want same track execution time for control load. So how we can do this right? Again we need to copy paste same kind of code across all the method in all the class which is not a feasible solution. Why not we will create our own custom annotation who will handle this execution time tracking. So for that we can use Spring EOP around advice and we can create our own custom annotation. That's what we are going to learn in this tutorial. So we will create 1 custom annotation and we can write on top of method so that that annotation will help us to evaluate. Execution time for a particular method. So yeah, so let's quickly create a Springboard project to demonstrate this Spring APR example. Let's get started. So let me remove this piece of coat which we just added which is cross coating logic and that we want to segregate from our core. So let me remove this. And we are going to use Spring EOP around advice. So let's create a package called advise. Com. Jabatiki. Dot spring. .Ap.Api.advice. Create a advice here new then class something like execution time. Trucker. Advice. And you need to annotate this with other aspect. And we need to annotate this with at the rate component. As we are using Spring EOP, we need to add spring EOP dependency. Never found XML right? So let me add spring AP dependency here. So let's add it here. Now go back to our advice and will write a method or something like public. Then the return type will be object. Track time. Or you can mention something like log execution time as this is the around advice we are going to use, we need to pass the proceeding joint point. OK then we need to get the start time and end time. So let's do that long start time system. Dot current time millisecond. Similarly we want end time. Just change the variable name to end time. And as you know there is a parameter called proceeding joint point once we will call this proceeding joint point. The rusev then it will behave as a after returning advice. So before this method call it will behave as before advice and once we call this method then it will be able to after returning advice. That's what the around advice will long in our previous tutorial right? So let us do the what I can do, I will return object. Now we get the start time before method call and we get the end time after method call. OK. Now we can easily track the end time and start time. We just need to subtract end time start time. Then we will get the actual execution time for a method. So that's what we are going to log. So let's use the logger. Get get logger off. Our aspect. So here we can write. Let me return the object first. Here we can write this log statement Blogger .info. Then we need to specify the method name so that we can easily identify that which method is taking time. So we can specify something like method name. Then you can get the method name from proceeding join point that get signature. Yeah this will give the method name then will write time. Taken to execute. And let's subtract N time minus start time. So let's add some. Spacia, yeah. Why there is some comparison error? Yeah, so we didn't. So let's. And let's throw the exception. OK so here we created a method. We will track the execution time. What we can do we need to annotate here around advice. And we need to specify the point cut here. But I don't want to apply this track time logic in a specific method or in a specific class. I just want to create a annotation who will execute this business logic. So for that instead of giving the point code here we will create a annotation and we will give the fully qualified name of that annotation here. So that whenever you will use that annotation it will execute that piece of code. This piece of code this annotation will execute. So you will understand this with one example. Let us create me the annotation 1st. So in advice only I will create a annotation. Give the annotation name something like. Trap execution time. OK so this track execution time is my custom annotation. Here I just want to specify target. In target we need to specify on which label you want to apply this annotation. So I want to apply this annotation on method level. So let's specify element type dot method. We're proud of our installations and prouder still the impact they're having. From one corner. And we need to specify the retention right. Retention means like whether you want to apply this on compile time or runtime like that. So let me some. Then you need to add the retention policy dot we want it to be applied on runtime. Right, we created this annotation and we need to give this fully qualified path of this annotation to our around advice. So let's do that. Around advice, you can write annotation. Then the fully qualified name of my annotation. So the annotation name. Let me copy the name. I like to copy the class name means this is the annotation name. OK, so we are good. Now wherever I will use this track execution time annotation, the request of the control will come to this advice which is our around advice and this piece of code will execute. That's why I didn't specify the point code. Here I specify the annotation fully qualified name of my annotation. So let's use this annotation in our method label where exactly we want to track our execution time. Let's say I want to track the execution time for this particular find all products method. So what we can do we can use our own annotation. Track execution time. Right, this is now. Once request will come to this final product it will go to based on annotation it will go to the advice. This execution time tracker advice and it will execute the piece of code. It will evaluate the start time before method call and once you call the method it will it will. Call our actual target method. Then we are invoking the end time and we are starting both of them to get our actual time. It will return in millisecond right? So let's run this application to verify like we are getting the log statement or not with our education time. So let's go to the main class. It's run this application run a Java application. Yeah so application is open port 8080. Let me clear this console. So let me hit the rest endpoint which will call this find all product. Go to the controller. This is the. Restaurant who will invoke our find all products, right? So go to the browser. And type your local. Host then the port is 88 plus. In the URL Fine products. We're getting 10,000 record here in browser, so let's go to the console to verify the lock. Statement let me zoom this yeah so you can see here right method name the products are. Parvis find all product method and it took time to execute. 122 millisecond, right? So if you want to track for other methodology, let's say go to the product service. I want to track the execution time for this. Add product method. You can do that using the annotation. So previously what people are using they are doing the system dot current time millisecond in each and every method call. So this is what we can reduce using Spring EOP right using this annotation. So let me taste this art product method. Yeah it will restart as you added the depth dependency. Let's go to the postman and this is what the local host 8080 slash save and this is what the two list of product object I am going to send. Click on send. It got saved, so now you go to the console. You can find your product service then add product method with input list time taken 11 milliseconds right. Similarly whenever you want to track your execution time you can simply use this annotation to get that proper execution time as a log. If you want you can write in a file. That is what depends on your log appender how you are maintaining logging statement in your application. So I will add this source code link in our GitHub and I will share the gate of link in video description so you guys can download it. That is what we can track our execution time using spring AOP around advance. Yeah, that's it about this particular video, guys, watching this video.

Spring AOP - Custom Annotation to Log Method Execution Time (@TrackExecutionTime)

Performance matters. As developers, we often need to measure how long a method takes to execute, especially for heavy business logic (e.g., database operations, API calls, bulk processing, etc.).

Instead of manually measuring time in every method using:

long start = System.currentTimeMillis();
// method call
long end = System.currentTimeMillis();
System.out.println(end - start);


We can build a reusable, clean, and non-intrusive solution using Spring AOP and a custom annotation.

🎯 Goal

Create a custom annotation: @TrackExecutionTime

Whenever applied on a method, it should automatically log:

MethodName executed in X ms

🚀 Step-by-Step Implementation
1️⃣ Add Dependency (if missing)

In pom.xml:

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>

2️⃣ Create Custom Annotation

📌 TrackExecutionTime.java

package com.javatechie.spring.aop.api.advice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackExecutionTime {
}

3️⃣ Create AOP Aspect

📌 ExecutionTimeTrackerAdvice.java

package com.javatechie.spring.aop.api.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {

    @Around("@annotation(com.javatechie.spring.aop.api.advice.TrackExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint point) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = point.proceed(); // execute target method
        long end = System.currentTimeMillis();

        System.out.println(
                point.getSignature().getName() +
                " executed in " +
                (end - start) + " ms"
        );

        return result;
    }
}

4️⃣ Apply on Target Methods

📌 Example: ProductService.java

@Service
public class ProductService {

    @TrackExecutionTime
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @TrackExecutionTime
    public Product saveProduct(Product product) {
        return repository.save(product);
    }
}

🧪 Testing

Hit an API from Controller or Postman:

GET  http://localhost:8080/products


Console Output:

findAllProducts executed in 122 ms

🎯 Key Takeaways
Before AOP	After AOP
Repeated code everywhere	Clean & reusable
Hard to maintain	Centralized control
Manual time tracking	Automatic logging
No separation of concerns	Follows clean architecture
📁 Folder Structure
src/main/java
 ├─ advice
 │   ├─ ExecutionTimeTrackerAdvice.java
 │   └─ TrackExecutionTime.java
 ├─ service
 │   └─ ProductService.java

⭐ Why This is Better

Cleaner code (no repeated timing logic)

Annotation-based = easy to enable/disable

Works for any method

Decoupled from business logic

AOP follows best practices

💡 Next Enhancements (Optional)

You can enhance by:

Logging to a file

Adding method arguments to log output

Sending performance events to ELK / Prometheus / Grafana

Applying at class level for all methods

📌 Final Result

Just add @TrackExecutionTime wherever you want:

@TrackExecutionTime
public void sendEmail() {
    // business logic
}


Output:

sendEmail executed in 57 ms

🎉 Done!

You now have a reusable Spring AOP performance tracker 🚀

If you want, I can also:
✅ build a GitHub README version
✅ generate code templates
✅ add Spring Boot demo project ZIP

Would you like a downloadable project + commit message? 😊