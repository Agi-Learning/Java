# Spring Cloud Function | @functional

* Yes, people are running behind something called functional programming with serverless architecture. So let's understand what is this serverless functional programming. So I will explain this concept by taking reference of Spring Cloud Function. So this is what the Spring official documentation where Spring Cloud Function is a project with the following high level goals. So the first one it promote the implementation of business logic via functions. It means simply we can expose our business as a function. Here the 2nd 1 decouple the development life cycle of business logic from any specific runtime target so that the same code can run as a web endpoint. So. We can simply expose our function as a REST endpoint without having interaction with any kind of server or any kind of operating system. And IT support a uniform programming model across serverless providers as well as the ability to run stand alone. So it can be locally or it can be platform as services. So this spring cloud function will be more helpful if you are using any cloud deployment in your application and specially it will be more flexible with AWS. Apart from that it enables Springboard features like auto configuration, dependency injection and serverless providers. So we will understand this concept with one useful example. But before jump to the example, I would suggest you to first learn how to do the Lambda expression in Java 8. And how we can use those functional interfaces which is Supplier, Predicate, Consumer and Function OK. Because in Spring cloud function we are going to play with these four interface which is the functional interface introduced in Java 8. So let's quickly create a Springboard project to understand this Spring Cloud Function. Let's get started. So let's create a Springboard project. Click New Spring Starter Project. So name it Spring Cloud Function example. Click next. I'm not going to add any dependency because couple of dependence you need to add manually.I. So click on Finish. So application inputted successfully. Now go to pond XML let me zoom this pond XML, change the springboot version. I'm using 2.1 .4. Change the other dependency right? So copy this. Test the dependency. So I added your lum book dependency on dev tools. Along with that I added Spring cloud function compiler and spring cloud starter function OK. So these two dependency specific to the string cloud function and this is what the dev tools I added for to reload our application and lumbo we added to our Gator setter right? And the cloud version we are using here. This is what the cloud version we are using. So let me save this. Now let's do a Maven update. Yeah so there is no error. Now we are good. Go to the main class. So here we are going to expose our business as a function and we are going to use the Java 8 functional interface. So let me show you that we are going to use the function Consumer and supplier and you can observe here each interface contains only one abstract method which we are going to use in our example. So let's use the function first. Let me write a method. Function. So we can use this java.little.function. So it contains two type generic which will be target and resource right? So let's specify target as a String. And resource as a string. So let's write a business something like I want to reverse the string OK. So as we are using functional interface, the interface name is function. As I shown you the function interface contains the method. Let me show you in that image, so it contains applying which is accept the target and it will return the resource right? So go to the eclipse, let me close this. So let's write logic for it using Lambda expression. So 1 second let me go to this interface. We have the method apply right? So copy this method. I will show you how we can represent using Lambda also Lambda. This will be my anonymous function. I do not want the method name and return type here. So this is my argument, I can name it something like input and it have the return type right? So we can do something like this. We can directly return the input. And as this method will return the function so we can simply add written. OK but here our goal to reverse the input right. So what we can do? We can do new string builder. Here I will pass the input. And I will call them reverse method. Then I will come but it. Now whatever the input I will give, it will convert and it will reverse it. Similarly we have other interface like Supplier and Consumer. So let's use those functional interface. Let me write another method public let's say Supplier. So we can see the supplier. Supplier is come from java.youtube.function and it contains only one argument. So let's go to the Supplier interface, it have the method gate method, it will always expect the return, it don't allow them any method argument right? So let's go to the code. So here we can change the type generic. Let's use some custom object, let me name it like Book. We'll create a book class OK. Then let me write the method get Book. A little written so before that let's create the book object first one. This one let's create our own Book class. Create a class Book. So let's start failure private hint ID. On private string name. OK so as we added Lambok here, let me use the Lombok annotation. Do you want whole argument constructor? We want no argument constructor. Yeah, that's enough. So go to your supplier code. Here we can simply return. New book, right? So we have to feel something like let's add 101 and name something like core Java. So we added for function and we added for supplier. So let's use the last one. Which is our consumer. So let's use consumer. So if you go to kanji more. It contains accept method with one argument right? And the return type. You can see void here. So simply will pass one input here and we'll just print it right? So let me copy this method. So go to the code, add something like specify string here. And I just want to print it right print message something like that. So what we can do written are the method. It have only the method argument. So let's remove the method name as we are going to use the Lambda here. So give the name something like input and simply I just want to print it. OK so we used three interface which is the functional interface. So to use String cloud function we need to add those at the rate Dean. annotation. This is what the rate Dean we are using for Java based configuration. If you add this other rate bin annotation then Ioc container will instantiate this bin OK. So I had been in each case. So if you observe here, let's assume this is what my function or this is what. My business and I want to expose it as a function so using this reverse I can call this business as a rest endpoint. So if you observe here I don't have any kind of URL mapping or I didn't mention any HTTP method still I can access it using rest endpoint with the help of method name. So I will show you that. So let's run our application. Let me try this, yeah. Ronan's Java application. Yeah, so we can observe here. It's open port 8080, so go to the command prompt. To go to the command. Then go to the directory where you created your project, right? So I have my project inside this Springboot and split in the whole mistake, hardware, working professionals, career because they're focusing only on technical skills. Yes, more. Clean cloud function example, go to this directory. Then we need to hit the core lever OK. So let me show you the two at the call expression here. Call then header section. My content type is text plus plane and local loop. This is what my port 88. My server is off and I specify the method name. So if you go to the eclipse. You specify the method name as reverse right? So with this method name I am going to access this API which will be behave like a rest endpoint OK. So go to browser and this method will reverse the string. Whatever the input will give, it will just reverse it. So let's run this. You can see here. The input which we pass which is Java taking it got reverse right? So similarly we can check the second API which is our gatebook OK. Let me copy the method name. So it will just print the Jason. So what we can do? Just need to change the content type to Application Jason. Slash Jason. And then we need to change the method name. Which is get book OK here we don't want any input. So let's hit this URL. You can see here the Jason response right ID and name. So if you observe here we don't have any kind of URL mapping still we are able to access this function with the name of method right? So let's go to this print message. So here whatever the input will give, it will show some console. So go to the command. Use the first one, just need to change the method name right? So the content type take slash plane and local host 8080. This is what my print message. So let me add some different message here. Dhararma. Welcome to. Java tech. So if I will enter this now if I will go to the console so you can see the input is getting printed in our console as in print message method we took the interface as consumer interface and it contains the method accept who don't have any return type word. So that's why we print the input rate and we can able to see that response. So we are good all the three function is working as expected and we can design this in another way if you don't want to add multiple bin. For your interface what we can do? You can create a class. Let me create a class something like Test. So it should be uppercase. Change the class name. So here in this class. Yes we can implement it from the functional interface. You can use function consumer and supplier whatever you want. So as of now I am using eigen function. So here specify the target and resource I specify both are string Then you need to overwrite the method. So this is what my input. I'm writing something. So. Therberglace. Functional programming. Example but then I will give the input OK that I want to display. So instead of doing bin in each and every function whatever the function you want to expose, you can create a class and implements from corresponding functional interface then. We need to inform to the spring context to scan this class right. We didn't annotate your component or configuration anything here. Then how spring context will know that this is what the functional class. So for that we can go to application properties file we can type here spring dot. Cloud dot function so we can find here something scan packets right? And we need to give the package name. As you added dev tools in every chance my application will have to reload here. So let me save this. OK so now I can access this test which is my functional interface. Means I implement from the functional interface to expose my business as a function. I can access this with the name of class. So this class name will be gave as a rest endpoint right? So if you observe in other case we just use the method name in command and this method name act as a REST endpoint means rest URL. Similarly if you create your own class and implements from any functional interface then that class name will act as your URL. So let us go to browser. Sorry the command prompt. So here what you can do just. Change the URL so we will get the taste. This is what the class we created and give some message. Let's give me Jabatiki. So we can get the output here right? Serverless functional programming example by Java Tiki. So if you observe your we used arthritis. PN annotation we provided method name of the unit right so? The hero is get book hero used print message. Here we use the reverse. All three are the method name. If you are customizing your functional interface by implementing any function then we need to pass the class name as a URL right. So this is how we can work with string cloud function. So we will understand more once we integrate with a double S. So that I can explain this spring cloud function in better way. That is it about this particular video guys. Thanks for watching this video. An unexpected increase in website traffic can overwhelm your servers and underwhelm your customers.


# Spring Cloud Function | @functional

Yes, people are running behind something called **functional programming** with **serverless architecture**. Let’s understand what this “serverless functional programming” is using **Spring Cloud Function**.

---

## 🌩️ What is Spring Cloud Function?

According to Spring’s official documentation, **Spring Cloud Function** is a project with the following goals:

- **Promote business logic as functions**
  → We can expose business logic as a function.

- **Decouple development of business logic from runtime targets**
  → Same code can run as:
  - a web endpoint
  - a serverless function
  - a standalone runnable service

- **Uniform programming model across serverless providers**
  → Works well with:
  - AWS Lambda
  - Azure
  - Google Cloud Functions

- **Supports Spring Boot features**
  → Auto-configuration, DI, etc.

---

## 📌 Java 8 Functional Interfaces

Before starting, understand these Java 8 interfaces:

| Interface   | Usage |
|-------------|--------|
| `Supplier<T>` | Supplies data (no inputs) |
| `Function<T,R>` | Input → Output |
| `Consumer<T>` | Takes input, returns nothing |
| `Predicate<T>` | Conditional check (true/false) |

We mainly use: **Supplier**, **Function**, and **Consumer**.

---

## 🚀 Create Spring Boot Project

**Dependencies to add (pom.xml):**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-function-context</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-function-web</artifactId>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
🧩 Implementing Functions
1️⃣ Function: Reverse a String
java
Copy code
@Bean
public Function<String, String> reverse() {
    return input -> new StringBuilder(input).reverse().toString();
}
2️⃣ Supplier: Return a Book Object
Book Class
java
Copy code
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String name;
}
Supplier Bean
java
Copy code
@Bean
public Supplier<Book> getBook() {
    return () -> new Book(101, "Core Java");
}
3️⃣ Consumer: Print Message
java
Copy code
@Bean
public Consumer<String> printMessage() {
    return message -> System.out.println("Message: " + message);
}
🌍 Testing via Web (No Controllers Needed!)
Application runs on port 8080 by default.

▶️ Reverse String (Function)
bash
Copy code
curl -H "Content-Type: text/plain" \
     -d "JavaTpoint" \
     http://localhost:8080/reverse
Output:

nginx
Copy code
tniopTavaJ
📦 Get Book (Supplier)
bash
Copy code
curl -H "Content-Type: application/json" \
     http://localhost:8080/getBook
Output:

json
Copy code
{"id":101,"name":"Core Java"}
🖨️ Print Message (Consumer)
bash
Copy code
curl -H "Content-Type: text/plain" \
     -d "Hello Cloud!" \
     http://localhost:8080/printMessage
Console prints:

makefile
Copy code
Message: Hello Cloud!
📌 Exposing Functions via Class Implementation
java
Copy code
public class Test implements Function<String, String> {
    @Override
    public String apply(String input) {
        return "Serverless functional programming example: " + input;
    }
}
Register in application.properties
properties
Copy code
spring.cloud.function.scan.packages=com.example
Call
bash
Copy code
curl -H "Content-Type: text/plain" \
     -d "JavaTpoint" \
     http://localhost:8080/test
🎯 Summary
Feature	Traditional Spring	Spring Cloud Function
Define endpoint	@RestController + mappings	Method name or class name is endpoint
Runtime	Server required	Serverless / AWS Lambda ready
Deployment	JVM app	Portable across clouds

🎉 Final Thoughts
Spring Cloud Function helps you:

Build serverless-ready Java apps

Reuse logic across multiple cloud platforms

Write less boilerplate code

Focus on pure business logic

💡 Next steps: Integrating with AWS Lambda for real serverless deployment!

yaml
Copy code

---

If you'd like, I can also:
✨ generate a **downloadable .md file**
✨ provide diagrams or architecture flows
✨ show AWS Lambda deployment steps

Would you like the **AWS Lambda version next?** 😊