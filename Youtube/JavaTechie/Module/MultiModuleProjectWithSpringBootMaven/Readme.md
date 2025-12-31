# Multi-Module Project With Spring Boot | Maven

* This tutorial will discuss how to create multimodal project using springboat application. So before jump to the code we should know the need of this multimodal project, isn't it? So as usual let's consider one each case to understand more about this multimodule project. So let's assume I want to develop 1 Hospital management system OK. So for that what I need to do? I need to write couple of services. Let's say I wrote Dr services, SN services, Diagnosis Services and Billing services. So if you observe this approach looks good right? Then why we need multimodal project approach? So to understand that we need to find out disadvantages in our traditional approach OK. So the first disadvantages I can say the code reusability let's say from billing service I want to use couple of class in DR services. So in such case as both are separate project I need to copy paste those class in doctor services. Same for if from diagnosis services I want to use couple of class in patient services then I need to again copy paste those class. I can't reuse those class instead of I am doing here code duplication isn't it? And the second problem let's consider in my production server DR service getting failed OK and I know the fix it is getting filled in DOW layer or in repository layer OK. So to fix the tissue again I need to reveal doctor service and again I need to push it to the production server so we can optimize it. Like I can create separate repository module or separate service module. So if the issue is in repository module then I can fix that and I can re deplete that particular module instead of entire DR services. OK so similarly we can consider one more disadvantages. Let's say I have some common generic notification service OK. So who will take the responsibility to send a notification to multiple user. So if I want to use that particular notification service in doctor service Oregon diagnosis service then I need to do the REST call to that particular service, isn't it? So always doing the REST call is not a good app use. Instead of doing that REST API call we can make that our service is generic and we should reuse it. That's what the problem in our traditional approach. So now. Let's understand how we can overcome these three issue using our multimodal project OK. So this is what the disadvantages we discuss reusability, maintainability and unnecessary web service call OK. So to overcome that issue we can go through the multimodular approach where we can keep one as a parent module and we can write a service module and we can write a controller module and I can write a repository module. So whatever the application I have in my project, all the service layer I can keep in this service model. Similarly all the controller classes I can keep this in control load module and for repository also I can keep all the repository in this repository model. So in future if I need to use particular repository module to this of this module I can add this repository module as a dependency in this services OK. So I can do change in this control load model and I can build this particular model instead of build my entire project. Isn't it so this this is the typical architecture of multimodal project where we should have one parent model and inside the parent model we need to add multiple models based on our business. So will understand more about this multimodal project once we'll start the development. So let's get started. So going forward let's use this intelligent ID for all our Java development. So let's quickly create a multimodal project here click on File New then click on Project then click on this spring assistant it will Then you need to give your group ID and artifact ID all this stuff OK. So let me give the group ID com Java ticket then application name I'll give Hospital management system. And then I need to choose the project type as mavenpom because this is what I want to generate as my parent module and then I can give the project name here as. Same as my hospital management system so.  And then I need to choose the project type as Maven pom because this is what I want to generate It has my parent model and then I can give the project name here. M as my hospital management system so give some description demo project. For Springboat multimodal application. Similarly you can change the package here. So I will give therootpackage.com.java tech. OK. Now click on this next. So let's add the required dependency to a lumber and I want to add web dependency which will be spring web. Then we want JPA here. Then we want in memory database. Which will be H2? OK so. All the dependence we are in now click on Next. Click on Shinnies and I want. Open at any window. So click on new window. Then let me minimize this top. Yeah, so if you will open this project we can see only palm.Xml, right? Apart from this Palm XML, you don't have any SRC or any resource soon. We can see all the dependency which we added right dot as AP then wave lumbo and H loop database. Now let's create the modular. So let's say for domain I will create a domain module. For service I will create a service module. So let's create that. Now click on new click on this model. Nag choosen maven music. OK then click on next then let me give the artificial name as domain where I can keep all my entity class OK or. I can keep my duty or Bo business object all the stuff here OK now click on next. Click on Finish. So enable this auto input. Now similarly let's create another module click on new model. So let me give the name as service. OK so all the. For this classes. I can keep inside this service module, click on next, click on finish. Similarly, let's create our repository OK. So click on. Next. Add here the artificial touch repository. Click on Next, then Finish. Then one more we want to add which will be our contribute click on Model next then add the artifact as controller. Or we can give the name as well OK click on next finish. Ah. So we created domain module where I can keep all the entity. Similarly we created repository model where we can keep our old layer. Similarly for service and for web OK and let's add one more module here let's give the name as email 1 S click on this module click next so give name something like email click on next and finish it. Now if you observe this Hospital management system is my parent model type and all the domain email, repository service and web is my submodule. So I want to make all the submodulars individual gel so that if the issue is in domain model or issue is in service model, I can fix that particular module and I can build it to the production right? So to make it individual war or jar, we need to set the packaging mode here. So the packaging is jar. So let's add the same in all the submodule. Let's go to our repository and add it here. Similarly for service. For web and for our email, right? Fine, now let's close all the open palm .Xml. Now let's add the business in our each module Search image. Go inside then you'll find Java and resource OK. So let's create package here com.javatech. Key Morden OK. Then inside this model if you go to slide, we have DR patient diagnosis and billing, right and it put all the model here for DR model, patient model and diagnosis like that. So based on that we need to build our package structure first, so. Add a new package model .something like DR. OK let me say this, click OK. Now let's add something like Peasant Model. So change. Patient. Similarly you can Add all other models, you can add building, you can add diagnosis. So let's add only two to show you the multimodular approach. OK. So now go to the DR. At the Entity class here let's give the name Doctor. So inductor let me add couple of field private int ID then private string name. Private stream. But I can specify here especially I. Hello. So. At Record, we believe everyone should be able to create software without limits and without money. Constructor then add two string and make this as entity OK. And this should be the primary key. Fine so we created the model. Similarly you can create your passion model inside the domain model and you can create your diagnosis all the stuff which we have in our architecture diagram. So we create a domain. Now let us go and let us create the repository here. So similarly what we can do I need to create a package. comjavatek.com you can switch back down.doctor. OK and similarly you can add yes and you. Create a package. You can specify dow dot present. So if you observe in the repository we added DR repository, we added Passenger repository and you can add diagnosis repository and building repository OK. So let me create the repository for DR, so create a interface, let's make it class. Then we can give the name something like Dr. repository. And extend it from the P repository. Give the model. Here the model is doctor. So if you observe this DR class is not visible to this repository module right? So to access the doctor field in this repository what you need to do, we need to add this domain as a dependency in this repository model. So go to palm XML, add here dependencies then specify the dependency here. Give the artificial ideas domain so we can add control space. Then group ideas com javateki. It should auto populate but something going wrong in my idea. Right. So now if you go to this DR repository, now if you type doctor you can see it here right at the doctor and give the primary key which will be our integer. Yeah so we created repository now. Now go to this service and let's create our services for Doctor, for patient and for all other modules. So you create a package here. com.java Tk.service.doctor. Click OK similarly create package for our patient. Now in DR service unit to add DR service related logic. But in DR service you need to access this repository right? So to access it from services what we can do go to com XML and we need to add here repository as a dependency OK. So are the dependency here dependencies? Then are the dependency and specified like repository. So give the proper name. Yeah, you can find it here. Then go go to our group ID. You can find com Java tiki so let me add it here. Heart control space, yeah. We can see the repository here right now. Go to your package, go to doctor, create a class. Doctor services. So annotate this with at the rate service. Now we need to inject the repository here right? Private DR repository. As you added DR repository as a dependency in service, you can able to see this class OK so add it. Injected using autoware. Yeah now let's write some logic here to what we can do to get all the doctor OK. So first to get I need to add couple of Dr What I can do public word. Unit Dr I want to initialize couple of DR So what we can do? Let's add this as at the rate post construct. And let's call this repository dot save all and create list of Dr here OK. So what I can do I will use stream here. Stream of. New Dr. So the ID is let's keep something like 101 the name, give something like Job, and then give them specialist OK. Something like Cardiac, something like that OK. So let's add one more Dr. object. Let me copy this. Its giving error because we need to convert it to two list. Now let's add one more doctor. Here let's add comma and give the ID to 2 and name. Peter. And give the specialist something like. Eye specialist. Fine, so we added two Dr. objects. So let me split this so that we can see it in proper format. OK. So let me add the semicolon here. Yeah, now let's write a method. We will fetch list of Dr object and it will return back pure controller, so public. List of specified the generic doctor. OK so specify get Dr something like that. Our return repository Finder, yeah. So we are done with our service. Now let's go to our web. We will write our controller. So I am adding only related to doctor. Similarly I created separate package for patient. So you can add your patient service and in repository you can add patient repository. So I am just to show you demo I am creating one of them OK. So now let's go to our web and let's create our controller. So first let me create a package. New package com javatek. Dot controller OK. So specifically the name Doctor Controller. Then similarly create for patient. OK now in DR pulled. Just create a class called DR Controller. And annotate this week at the rest controller. And to access this service inside this web we need to add this service as dependence in this web model, isn't it? So go to palm.Xml, add the dependency. Give the dependency structure add the artifact ID here as service then. Specify the group ID as com Java tech. It should suggest now save it. Now let me close all these open file. Now go to your controller. Show in control zone what we need to do. We need to inject the service right private doctor service then service inject using autoid right? One year let's write understand point public. Let's say it will return least of DR. That's the name something like Get Doctors. OK and I will return it from surveys dot getductors and another this way gate mapping. Give the URL something like doctors. OK so this is the web application and to run this application we need our Springboot name class right? So what I can do I'll write that inside this web component. So create a Java class something like Hospital Management System application. So you annotate this class with. Arthur at Springboot application. And need to add the main method. Here you need to write springapplication.run and give the application class name right HMS application .class. That's it. Now this is what our main application right? So this is what the main class and to run this application we need web dependency isn't it? So what we can do go to our parent palm where we already added the web dependency so let me copy the same dependency control C. Then let me add it in our webpam XML so. Let me add it here, yeah. Now go to our HMS application. So here we need to enable components because we are not following the structure right. We are using multimodal project so components can give the base package here. So what I can give we can specify the com Java Tiki which will be our root name right com javatiki dot star so. Similarly we need to enable the entity scan because in our domain we are writing multiple entity right? So entity scan. Same give the best package. Let me copy this. Leave the base packages here. Add it here similarly what we need to do? We need to enable the JPA repository right? So here also we need to provide the root package right? So give the waste packages. I'm already here could be paste yeah so we enable components, can we enable entity scan and we enable GPU repository as my all the package structure start from com Java techie then I'm giving this as my root package OK. So now you can run this application OK. So before run this application let's add H2 console. Let's enable it so that we can see the browser what are the data present in our in memory database. So what I can do I will create one folder here let's say the name file application dot properties. OK so here I need to enable the H2 console right? So the key is spring H 2 dot concern. Dot enabled OK and specified. Now save it. Now let's go to our main class. Now let's draw this application. Draw on this HMS application. So let me open the console. Yeah so if you observe application is open port 8080. Now let's go to browser to see the H2 console database input. So localhost. 8080 slash H2 console. Yeah click on connect. We have the DR table drive. Now run this script. Yeah we have to record one 01102 name John and Peter. So now let's go to browser. Once open a new tab, type Local roast. 8080 slash doctors write. We're proud of our installations and Prowler still of the impact they're having. Yeah you can able to see the tour record right which we added in our in memory database using at the rate post construct annotation. So. Looks good. We converted our traditional approach to multimodular approach and we are able to access our application right. So if you go to our code let me minimize this console yeah, so we have web service, repository email domain. Right. Now let's say in serve this or this email I want to use in this service. So simply what I can do, I will add this email as a dependence in this service. So this email I can make it as generic so that whatever the service I have let's say. In service I have doctor service, right? In doctor service I can use the same email application. If in patient service there is some requirement to send notification, I can again reuse the same email right? So let's do one thing to show you the reusability. What I can do? Let's go to this email. Let me create a package here so we are not getting the package option here. So what I can do let me delete this application OK. Then I will create a new one. Please right click then new module click on next. So give something like email app. Click Next finish. Yeah, so again are the packaging mode here jar. And now go to this email main, yeah? Now we are getting the structure right Java richards. So click on new specify the package here something like com. Javaticket.mail service. Yeah, so here you can create a class. Email service something like that. Yeah, so I wanted this with the red service. And simply I just will write the public word method to show you that we can reuse the same functionality OK send email. So we should make this application Oregon, this email services generic right? So that any type of argument, any model can pass and they can access it. So what I can do? I simply learn something. Female services working, something like that. OK now save it. So this email service I want to access it from this doctor service. So what I need to do go to the palm.Xml and add that email API as dependency here right So what you can do dependency in artifact ID you need to specify email app. And go to thisgroupIdtypecom.javateke. Yeah, fine. Now save it. Go to yourself. Please go to your Java DR Model Doctor services. So here what we can do, we'll simply add one. We need to inject the email service here right? Private. Email service. Service injective using auto aid. And simply from this girl doctor's method I'll call service dot send email, right? So that in console you can see the message which will get from the send email. Right now if I need same email feature to use in patient service, I can simply inject that and I can reuse it. Similarly whatever the subdis or whatever the module you have, just inject that particular dependency or particular module just reuse it. Now let's run our application once again let. Let me stop this. Yeah, let me start the application. It is building all the muddle you can see here Parsing Java Web. Started. So if you observe your application is upon port 8080. Now once again go to browser. Let me refresh this. We can see the two record here and if you will go to the control. Let me go down. Email service working right. So now this email service I can access across my application. So wherever I need to access that email service simply I need to add that email API as a dependency and I can reuse it the way we did in this doctor service. So if SN service net again you need to inject that email service and you can reuse the code. Yeah so this is how we can work on multimodal project in real time. And I found in maximum project people are using this multimodular approach. That's why I prepared this content. Hope you guys will enjoy it. That's all about this particular video guys. Thanks for watching this video. Meet you soon with a new concern.

Multi-Module Project with Spring Boot — Maven Guide
📌 Introduction

In this tutorial, we will learn how to create a multi–module Spring Boot project using Maven.
Before jumping into development, let’s first understand why we need a multimodule approach.

🎯 Traditional Approach

In a typical project like a Hospital Management System, you may create separate services:

Service
Doctor Service
Patient Service
Diagnosis Service
Billing Service
🚫 Problems in the Traditional Approach

❌ Reusability Issues
If Billing Service needs a class from Doctor Service, code must be copied or accessed over REST.

❌ Maintainability Issues
If Repository layer of Doctor Service fails, we must redeploy the entire Doctor module.

❌ Unnecessary REST Calls
Common utilities (email/notification) must be accessed via REST, increasing complexity.

💡 Multi-Module Project Approach
📌 Concept

We create:

A parent module

Child modules for specific layers

Parent Module (pom packaging)
 ├── domain       → Entities, DTOs
 ├── repository   → Spring Data Repositories
 ├── service      → Business logic
 ├── web          → Controllers (Spring Boot starter app)
 └── email-app    → Reusable utilities (e.g., email)

📊 Diagram
 Parent (pom)
 ├── Service Module
 ├── Controller Module
 ├── Repository Module
 └── Domain / Email Modules

🏗️ Implementation Steps
1️⃣ Create the Parent Project

In IntelliJ:

File → New → Project → Spring Initializer
Group ID: com.javatechie
Artifact ID: hospital-management-system
Project Type: Maven (pom)
Dependencies: Spring Web, JPA, H2, Lombok


Parent pom.xml (Important fields):

<packaging>pom</packaging>

<modules>
    <module>domain</module>
    <module>repository</module>
    <module>service</module>
    <module>web</module>
    <module>email-app</module>
</modules>

2️⃣ Create Submodules

Create modules:

domain
repository
service
web
email-app


Each must have:

<packaging>jar</packaging>

🧱 Domain Module

/domain/src/main/java/com/javatechie/model/doctor/Doctor.java

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    private Integer id;
    private String name;
    private String speciality;
}

🧑‍💻 Repository Module

Add dependency to access domain module:

<dependency>
    <groupId>com.javatechie</groupId>
    <artifactId>domain</artifactId>
</dependency>


DoctorRepository.java

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> { }

⚙️ Service Module

Add dependency:

<dependency>
    <groupId>com.javatechie</groupId>
    <artifactId>repository</artifactId>
</dependency>
<dependency>
    <groupId>com.javatechie</groupId>
    <artifactId>email-app</artifactId>
</dependency>


DoctorService.java

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository repository;
    private final EmailService emailService;

    @PostConstruct
    void init(){
        repository.saveAll(List.of(
                new Doctor(101,"John","Cardiology"),
                new Doctor(102,"Peter","Eye Specialist")
        ));
    }

    public List<Doctor> getDoctors(){
        emailService.sendEmail();
        return repository.findAll();
    }
}

📨 Email Utility Module (Reusable)

EmailService.java

@Service
public class EmailService {
    public void sendEmail(){
        System.out.println("Email service working...");
    }
}

🌐 Web Module (Spring Boot Runner)

Add dependencies:

<dependency>
    <groupId>com.javatechie</groupId>
    <artifactId>service</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>


Main Application

@SpringBootApplication
@ComponentScan("com.javatechie")
@EntityScan("com.javatechie")
@EnableJpaRepositories("com.javatechie")
public class HMSApplication {
    public static void main(String[] args) {
        SpringApplication.run(HMSApplication.class, args);
    }
}


DoctorController.java

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService service;

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return service.getDoctors();
    }
}

🗄️ H2 Database Configuration

web/src/main/resources/application.properties

spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update

🚀 Run the Project

From terminal:

mvn clean install
mvn -pl web spring-boot:run


Test API:

🔗 http://localhost:8080/doctors

🎉 Benefits of Multi-Module Architecture
Benefit	Explanation
✔ Reusability	Share common code like Email service
✔ Maintainability	Deploy & build only changed modules
✔ Separation of Concerns	Each part is independent
✔ Faster Builds	No unnecessary full rebuilds
🏁 Conclusion

A multi-module Spring Boot project is extremely useful in enterprise projects where:

Modules evolve independently

Reusable utilities are needed

Faster deployment is a priority

This architecture is scalable, maintainable, and production-friendly.

If you'd like, I can also generate:
✅ A GitHub-ready project structure
✅ A ZIP template codebase
✅ UML diagram of the module interaction

Would you like that? 😊