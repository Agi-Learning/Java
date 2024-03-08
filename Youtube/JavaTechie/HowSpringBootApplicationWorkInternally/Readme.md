# How Spring Boot Application Work Internally

* No Magic guys spring does not generate code on the fly, but not does it keep any XML configuration so it is simply using all programmatic configuration which is already done by playing good developer. And they provide as a jar means we are just using the pre configured jar provided by spinbook developer. So now you might guys thinking where is jar available right? So hope you

## Starter POM

* META-INF/spring.factories
  1. Enable
  2. Disable
  Based on @Conditional and @Configuration

* You have to turn call status. So while creating springboard application, you may notice that we are adding spring tattoo web or spring tattered jp or spring tattered taste. So when we are adding those tatter pump in Beam for basically it is not doing anything. It is simply, bring up all the jar for certain type of application, like stand alone or web application. So once we have the jar in our build for it internally contains something like ping dot factories. So the folder structure is meta inf slash factories. So what does this spring dot factory contents inside this spring dot factory is spring good developer mentioned. But should be enabled at runtime and what should be disable. So the entire process is dynamically guys. So inside the spring dot chatter is there is some properties. And based on the dependency, or based on the jar present in build for it will enable few of the component to build our application. And those components will be enable or disable based on some condition. So that's why it internally used at the rate conditional annotation. So if you observe this is introduced in string 4% before that there is a concept called like profiler, right? So the alternative of profiler is called conditional with some conditional statement. It will enable the component, like it will enable the repetitory, or it will enable the dispatcher servant based on condition that I will show you in code. So let me go to the clips.

Check Code ->

* Show informed xml. I added. springboard data gpa springboard And by default it will add the springboard startup taste. These are the stutter pump right. so now you will go to the build path The status jar will be present there in Belfair. Let me show you the These are the spring bootstrapped jpa or springboard auto configuration. So let me go to any of the jar. You'll find the directory called Metainf. And inside meta nf, there will be spring torus. So this is the meta inf. You can observe your spring activities Have you told me So these are the things will be enable or disable based on condition at runtime.
* Okay. So let me show you any of one component. Let's. search for jp repository. There's a class called JP repository auto configuration. Let's go to that class. This is worth the class. Like look in that yeah, it got open. So if you come to this class, they have the condition, ok?

* Status, there would be present there in Welfare. Let me show you that These are the spring bootstrapped jpg or springboard auto configure. So let me go to any of the jar. You'll find the directory called Metainf and inside meta INF there will be spring tourism. So this is the meta INF. You can observe your spring.factories
* So these are the things will be enable or disable based on condition at runtime. Okay. So let me show you any of one component. Let's search for JP repository. Okay, there's a class called JP repository auto configuration. Let's go to that class. This is what the class Let me look in that. So if you call to this class, they have the condition, ok? So condition on beam, data source, .class. If data source B in is available, then only enable Tulsa jp repository. So that's why we are adding data source related properties in our application properties file. Similarly, conditional on class. So if JP repository dot class is present then only of power JPA repository. Similarly conditional on missing beam or conditional on properties. There is few conditional statement based on that it will enable the JP repository and by default it contains. advert configuration. So in case of Java gas configuration approach, basically we are using this to alternate as AB So as we already discussed, if all the condition is satisfied, then only it will enable the JP repository compound. So that is what mentioned in spring dot factories. Not only JPA repository auto configuration, you can find for elastic search Oregon couch base or you can find for dispatcher servulate. So those are the things mentioned in spring dot factories. And this is dynamic based on the dependency you will add in your palm Those companies dont only be available in spring factories. This is one kind of auto configuration features of spring boot So now lets get to our slide. So now lets see three of the condition.

### Out-of-the-box conditions

* OnBeanCondition -> Checks if a bean is in the Spring factory
* OnClassCondition -> Checks if a class is on the classpath
* OnExpressionCondition -> Evaluates a SPeL expression
* OnJavaCondition -> Checks the version of Java
* OnJndiCondition -> Checks if a JNDI branch exists
* OnPropertyCondition -> Checks if a property exists
* OnResourceCondition -> Checks if a resource exists
* OnWebApplicationCondition -> Checks if a WebApplicationContext exists

* Show on beam condition on class condition like this. We have bunch of conditions. So in case of unbeaten condition, it will check if a bean is in the spring factory or not. Similarly, on class condition, it will check if a class is present in class path or not. Like this, multiple condition is there, which internally using by spring boot to a power component. If all the condition is satisfied, then only spring boot will boost that comparator So this is what we understand, high level overview of auto configuration features in the springboard. Now let us understand how spring boot kick off our application context and how it helps us to execute our application So what is it? Lets understand step by step.

### @SpringBootApplication

```java
@SpringBootApplication

@Configuration + @EnableAutoConfiguration + @ComponentScan
```

* While creating a spring boot application by default, it will provide a class with annotated spring boot application with mermaid. So we will understand step by step what is the need of this spring boot application annotation. Why we need main method and how it will kick our application context. So basically, this adtherates clean boot application annotation is the combination of these three annotation at the rate configuration, at the rate enable auto configuration, at the rate component scale. So at the rate configuration will behave that class as a beam. And at the rate enable auto configuration, as we discussed previously, it will enable few of the component based on the condition. And at the rate component scan helps us to scan our package or beam to. be registered in Ioc Containment, right? So let us go to this class, and we will check the internal of this earlier at spring good application. So let me go to the Eclipse So we're in Eclipse that we close to classes.
* Go to the main class. Okay. So this is my main class. This will be created by default with spring book. If you want, you can manually create this. So this is what the annotation we are talking about. Arthur at spring boot application. So let us go to this annotation. Ok. So in this annotation, as we discuss it already, like contents are there at enable auto configuration, at the rate component scan and at the rate configuration. So and this advertiser spring booked application annotation contents to attribute. This is, you had the attributed contents Exclaim. It means it will exclude specific auto configuration class so that they will never be applied. OK, if you don't earn few bin to be Register in IOC container. You can use exclude or you can. Can you specify the exclude name? Right? Similarly, there is a scan base packages and scan base packages class. If you want your application Oregon, your bin will be scanned by IOC container. You can specify the scan base package classes or you can directly specify the route package. So these are the 4 attribute present inside this At the red spring boot application and it internally contains enable auto configuration. Components can Run at the rate configuration So here what you understand about these arthritis spring boot application annotation. So basically, this single annotation helps us to scan our beam. That's why it contains arthur at components can and it enable the component at runtime. That is why it contains at the rate auto configuration. So now we may have question

#### why we need this main method in our spring boot application

* So basically, we are developing web application, or rest api, using spring book. So what is the net of this main method? Right? So main method is not required for the typical deployments scenario, or it is not required to building a wire. Oregon placing it to go back fold. So when we want to run a application from an id like. Eclipse or intelligent, we are drawn it as a Java application. It means the executable jar that can run standalone with spring boots embedded tongue. So with internally, use the command Java iphone jar, then journey, right? So normally, how we can run a jar? If you are going to run a jar from comment from we are writing Java, I can jar, then jar name. The same thing it is doing when we are run our application from id. Right. So that's why we need the main method as the execution starts from main method, then only our executable jar can be deployed in spring boot embedded thumbcare. That's why we need the main method in our spring boot application, right? So let's go to the code again. So we'll discuss further about the flow of children

#### SpringApplication.run(...)

* Following is the high level flow of how spring boot works.

* Ok, so from the raw method, the main application context is kick the then it will sort the class annotated with configuration. Then it will initialize all the declared beam in those configuration classes. And it will store in iOC container. After creation of all the required beam, it automatically configure the disposal servlet, and it will register the handler mapping, and it will add the message converter if required. And whatever the basic things required. to build our application, it will auto configure in our application. So this is what the spring application dot run is doing right. So this is what we understand high level overview of run method. Now let us understand the run method internal execution step so that you guys can get complete picture about the run method internal with example So let me move to the next slide.

#### run(...) Internal Flow

* Create application context
* Check Application Type
* Register the annotated class beans with the context
* Creates an instance of TomcatEmbeddedServletContainer and adds the context

* It is worth the step internally executing run method. So I listed all the stuff here. So first one is, it will create an application context. 2nd one, it will check the application type, whether it is web application or the stand alone, or it is reactive based on that. It will create the context. Then it will register the annotated class. Beans with the context. Then at end, it will create an instance of trunket embedded servlet container. And it add to the context so that our executable jar can be auto deployed to this trunk. This truncate embedded servlet container. So no need to worries. Guys, I will show all the step of execution with code. So let me move to the Eclipse.
