# Java SE 17: The Big Picture

## Introducing the Java Platform
## Adopting Java 17
## Working with Java 17
## The Wider Java Ecosystem

## Introducing the Java Platform


	Introducing the Java Platform
		LTS versions generally get the widest community adoption.
		Java is highly programming language it's important Java Platfrom 
	Check Tab -> 
		The Java language governs the formative source code, Which keyword you can use what rules you must follow when writing Java code; however, Java is more than just a programming language. 
		In facts, we can define the Java platfrom into 3 parts,
		1. Java programming language,
		2. Runtime environment
			The runtime environment is where java code is executed, and we'll see later that Jave's runtime environment abstracts away from the undelying operating system and processor architecture. 
		3. Standard Library
			Usually why rise application you don't want to write all the functionality from scratch. The Java standard library contains many commonly used functionalities, which you can reuse in your applications so you don't have to reinvent the wheel all the time. Think of a collection framework, date and time handling APIs, an HTTP client for calling web services, and much more. 	

		May be talking about either of these individual parts or about the whole, the combination of the programming language, RE,STL, 
		The three parts of the Java platform are bundled together in together are call Java Development Kit, or JDK in short

		You can't develop Java applications without the JDK. It contains all the tools that you need to create and run Java applications.

		To make the code executable, we have to compile its first using a java compiler, which we'll see in action shortly, 
		The result of compiling Java Source code for an application is the so-called bytecode for this application. Byte is lower level but still CPU and Operating system-agnostic representation of the source code that can be more easily executed by the JRE 

		Now, as we discussed before, applications don't usually write all their functionality without using other code. 

		In virtually all cases, they also use code from the JSE APIs, and as a quick aside, that is what the SE in Java SE stands for This implies there's more than one edition of the platform,

		JSE API's productively write modern java application That's why most java application also use third-party libraries. These libraries are published as bytecode as well and can be used from application code. 

		The wealth of available libraries is one of the great things about java that makes writing java applications very productive. Which uses parts of the Java standard library and possibly third-party libraries, but there are just bits and bytes on a disk, not a running application. 

		To run java applications, we also need a Java Virtual Machine, or a JVM. The JVM constitutes the runtime environment that we talked about earlier. JVM knows how to execute bytecode on a real machine because, of course, we still have real hardware and an operating system sitting beneath this tech. Now the hardware only knows how to execute native machine instructions, and java bytecode is not that. java bytecode in the higher level intermediate format that can be translated by the jvm into actual machine instructions for the hardware that the JVM is running on. We now have a complete picture all the way from java source code to our bytecode running inside of the JVM that knows how to translate this bytecode to machine instructions on the actual hardware. The setup may look quite complex and elobrate 

		Compiling and Running Java Code
		--------------------------------

		We compile the java source code to java bytecode using javac, the Java compiler. It creates a Hello.class file containing the bytecode for ur application. 

		We need a Java Virtual Machine to run the code. One example of the usage of Java SE API is the System class that we use in our program. The System class is offered by the Java platform to, among other tasks, make it easy to interact with the console. So here we use standard library functionality to output some text to the console. to run the bytecode in the Hello.class file that we created using the Java compiler, we can run it using the java command, which starts the JVM and runs our application code. 


## Adopting Java 17


### The Philosophy of Java: Readability

	* When and why is adopting java the right choice for you and your team? We start by zooming 
#### When and Why to Adopt Java?

	Check Tab -> 

	* Understanding guiding principles behind Java's evolution will also help you understand where it's going and see if it fits your goals.  Then, getting more technical again, We'll look at some of the most prominent characteristics of both the Java Programming language and the Java Runtime Environment. 
	What drives people to adopt Java? We close out this module by comparing Java to other popular programming languages. It's all about choosing the right tool for the right job, and knowing the essential differences between technologies helps in making that choice. 


Its an industry language. There are no ulterior acadamic motivations and Java's purpose is not to be on the bleeding edge of Programming languages, Whatever that may mean anyway. 

* More that 10 million Java developers
* Reading code is more important that writing code 
	SD has inherently collobration efforts You spend a lot of time reading and understanding other people's code; therefore, It's important to optimize this reading experience. 
* Understandable code over short and clever code 
	But that might really stand in the way of understanding the code, effectively decreasing the code's maintainability. Java tries to provide one clear way of expressing your intentions. Understandable code is encouraged over clever code because, lets face it, And yet this is so important when doing large scale collaborative development. 

### The Philosophy of Java: Stability

	Check Tab -> 

	* How do you create a readable and understandable programming language? 
	* By carefully evolving it and putting up a very high bar for introducing new language features and complexity. 
	- Conservative in adding new features
	* Java is quite conservative about adding new features. When a language has too many different ways of getting to the same result, its learning curve increases dramatically. Of course, Java also innovates and adds new features, but of many proposed features, only a select few will make it to a release. 
	- First do no harm
	* Java has taking a long view We've had more than 20 years of successful evolution in Java, and the goal is to continue that for the next 20 years. One sentiment often expressed by the java team is first do no harm, 
	- Productivity
	* Its much harder to take an ill-begotten feature away from the language than it's to introduce a new one. So, all new features should empower developers without conflicting with the existing features. They should make java developers more productive while also maintaining the simplicity of the language. Over the past years, several new large language features have been introduced. Many are inspired by what is done in other language but adapted so that it fits java's philosophy of readable and simple code. 
	* Java 12 introduced the notion of preview features where language features are first behind an experimental flag. 
	* This way real-world feedback can be collected shape the features before finalizing them. In the next module, we'll see some of these newer language features that were first previewed and then added to java in the versions leading up to Java 17. 

#### Backward Compatibility
	
	* Moving fast and breaking things sounds cool, But it turns out people don't want to build long-lasting business applications on a technology that keeps breaking existing code. It's another example of the first do-no-harm principle. Think of the massive time that potentially be wasted by those 10 million developers when Java breaks backward compatibility. Sometimes it needs to happen, but these cases are rare, especially when you keep backward compatibility in mind as a guiding principle, as is the case for java. 
	* Backward compatibility means that code written for earlier versions of java will compile and run on new versions without changes. what's more, code that has already been compiled to bytecode and distributed, for example as a library, will run on later versions as well. This enables that vast ecosystem of Java libraries to flourish, 
	* In general, you can expect Java code you write to work for a very long time, even as the platform evolves further. you can focus on the development of your business logic, not so much on the evolution of the underlying technology. 
	* In rare casese, backword compatibility may be broken; however, such breaking changes come with relatively long and predictable deprecation cycles. There's enough time to plan in these cases so you can change your code without unexpected surprises. Being strict on backwards compatibility inherently limits the amount of revolution that can happen in the platform. Instead, incremental improvements is Java's way forward. Coupled with the preview features mechanism and Java's frequent releases, this works surprisingly well. Java is stable, yet constantly modernizing and remaining relevent as ever. 

### Philosophy of Java: Openness & Community 

	* Oracle owns the brand name Java and is the major driver behind the platform, but Java itself is an open technology, and you can see this openness in several ways. First in the way Java is formally specified, second in the way the Java platform is actually developed, and third, in the community that has emerged around the platform. 
	* Java is Rigorous specification, There's a Java Virtual Machine specification which goes into great detail how a JVM execute bytecode and how the runtime should behave, and then there's also the Java Language Specification, which describes what valid Java source code looks like and how it should be compiled to bytecode. Even though the specifications are rigorous, They're surprisingly readable and are even published as proper books. The 
	* JCP Multiple vendors & community leaders
	* IBM, Red Hat, Azul, Microsoft, Amazon,...

	* IBM has its own JDK implementation, and many other vendors, as shown here, provide their own Java distributions. For us as developers, this means we benefit from an open ecosystem without being locked into any particualr vendor. 

#### OpenJDK

	* Another way in which Java is open is the fact that Oracle's reference implementation of Java, called OpenJDK, is hosted as an Open source project. As of 2020 all JDK development was moved to GitHub. You can view the repositories and see exactly what's going on. The Open JDK project also hosts many experimental subprojects on openjdk.net. There, you can also find so-called Java enhancement proposals, providing insights on where the Java platfrom is headed in terms of new features. 

* Last I want to highlight another site of Java's openness, and that's through the Java development community. As mentioned, there are over 10 million Java developers worldwide. First of all That's a massive hiring pool for any organization and part of the reason why Java is popular. More importantly there are hundreds of Java user groups around the world, and most of those organize events where Java developers meet, exchange experiences, and grow their skills. I personally find it to be a very open and welcoming community with many learning opportunities, and it shows that Java as a technology is very much alive and kicking. Java's openness over the past decades has led to a mature and productive platform that is widely used. If you're looking for technology that's way ahead and cutting edge, you'll have to look for it

### The Java Language
	Check Tab -> 

Why do people choose the Java Language?
	* There's a couple of reasons why Java was originally well received. First of all its syntax and core constructs are close to C and other languages in the C family. Practically this means that different scopes are enclosed in curly braces, here the class and method scopes, and it uses familiar forms of if/then/else, for loops, and switch statements. However Java also introduced a big innovation on top of the more procedural languages like C, Object orientation. By introducing classes as a means to combine data with fields on the class and behavior with methods on the class, a completely new way of modeling code emerged. Allowing classes to extend each other offers even more modeling flexibility. Java is definitely not the first OO Language. But together with C++, it was one of the first languages bringing the OO paradigm to the mainstream. 

#### Scalable Development
	Check Tab -> 

	In facts, OO Java turned out to be especially well suited for the ever larger applications that people are trying to build. Java offers a very scalable development model. It supports creating hierarchical and structured code bases that are well suited for large scale collaboration. As an OO language, Java starts out with classes as the foundational elements to organize code. At the next abstraction level, related classes can be grouped into packages and related packages can yet again be grouped into modules. Modules are a fairly recent addition to the java language, and if you want to know more about them, Each level of abstraction illustrated here allows you to encapsulate inner details and apply fine-grained access control between elements. Structuring your code bases using classes, packages, and modules helps you scale your development efforts for large code bases. 

#### Productivity: Type System
	Check Tab -> 

	* Another productivity boosting feature of the Java language is its type system. It helps to catch a problem earlier on, You need to be explicit about what the types are of variables you're creating. 
	* There are also languages that don't have static types in the source code, and without a compiler to check, the error is only detected when the code is run, and that's pretty bad because a user will see an upexpected error at runtime. Types help to catch bugs in the code early so developer can fix them immediately when pointed out by the compiler. 

### Java's Runtime: Portability
	Check Tab -> 

	First, it provides portability for java applications. 
	Second, as a managed runtime, the JVM relieves developers from many tedious duties. 
	Last, the JVM ensures great runtime performance for your java code. 

	Portability means that java applications should be able to run on any platform, that is on any operating system and any hardware. Java calls this the WORA principle, (write once, run anywhere) Write your application once in java and the java platform takes care of running it on Linux, windows or other platforms, including different CPU architectures. Why this is important we only have to look at how Apple has switched CPU architectures from PowerPC to intel and now to ARM for their hardware to see that target platforms are not as stable as we'd wish. Having to recompile or, worse, rewrite your application every time you want to target another platform would be bad. 

	Java's portability is achieved by the separation of the Java platform into three parts that we saw earlier. Remember, we have the application bytecode that's compiled from application source code which uses the Java standard library, the Standard Edition APIs, but what's missing from this picture is the runtime environment, and it turns out there is a JVM for each operating system and CPU architecture. 

	Ex: we take our application bytecode and run it on top of a Java Virtual Machine implemented for Linux in a 64-bit processor architecture. What if we want to run our application on, Let's say, Windows? In that case, we only have to swap the Linux JVM for the Windows implementation, which in this case targets windows on the x86 processor architecture. The crucial point here is that neither our source code nor our bytecode had to change. We only had to compile our source code once and it runs on different JVMs on different platforms. The Java SE APIs are platform-agnostic. Effectively, the APIs offer the largest common denominator of functionality across all platforms. You can be sure that when you use functionality from the Java standard library, it will work the same across all platforms. In the past 20 Years, JVMs have emerged for all kinds of platforms, from large mainframes to small ARM-based devices. Java has truly shown that it's possible to write once and run anywhere 

	There is a downside of this platform independence though. If you need to write code that integrates deeply with the operating system, for example when creating device drivers or hard real-time applications, the advantages offered by the JVM and its uniform standard library turn into disadvantages. In these cases, unmanaged languages are better suited, but what does that actually mean, an unmanaged language vs a managed language, 


### Java's Runtime: a Managed Runtime
	Check Tab -> 

	* The JVM is sometimes also called a managed runtime and Java a managed language because it manages many concerns for you for that other language An example is automatic memory management. In lower-level languages than Java, You as a developer have to indicate where and when to allocate memory for objects created in your code and, more importantly, also when to free that particular region of memory again. 

	In Java, the JVM handles memory allocation transparently for you when creating objects, you don't have to be concerned about where they live in memory and how objects are laid out in memory. Automatic memory management is only possible because of another related features the JVM offers as a managed runtime, 

	Garbage collectiion -> Since you can just keep allocating objects in your Java code, at some point you will run out of memory. Before that happens, the garbage collector kicks in. It will look at the memory that was automatically allocated so for and it can determine which objects are still in use and which aren't anymore. memory belonging to unused objs will be freed again so it can be reused. Java developers only have to think about business logic rather than memory management when writing Java code. 

	Multi-threading -> Another important feature the Java runtime manages for you is multithreading. CPUs nowadays have many core available, and by creating threads from your Java code, you can easily use the resources of multiple cores in parallel. The JVM takes care of scheduling the code running on different threads to all cpu cores. This, coupled with the concurrency APIs offered in the Java standard library, makes it relatively easy to write high-performing, multithreaded code without getting bogged down in hardware details.

	Performance -> Talking about performance, the way the Java platform is setup with its Java Virtual Machine allows for some very interesting optimizations, This may feel counterintuitive since the JVM actually introduces a layer of indirection between code and machine instructions; however, the setup also enables the concept of just-in-time compilation. The Java Virtual Machine translates bytecode into machine instructions for the specific processor to the JVM runtime; therefore, different JVM implementations for different platforms can really specialize for the underlying hardware. The JVM analyzes the execution of bytecode during runtime and can decide to just-in-time compile to very specific machine instructions of the current CPU that the JVM is running on, unlocking peak performance. 

	In contrest non-managed langs there's only a single upfront compilation step to generate machine code. This generated machine code has to be more generic to run across a large range of different CPU instruction sets. With Java, we have platform-independent bytecode and a platform-specific JVM, giving both the benefit of portability and the benefit of allowing highly specific optimizations for the actual CPU that the JVM is running on through just-in-time compilation. An enormous amount of engineering time went into these optimizations in the JVM over the past decades, and it shows. The performance of most Java code compares very favorably to other langauages. 

	Java's peformance benefits are nicely summed up by this quotes from James Governor, which says: "When we companies grow up, they turn into Java shops." And this is based on many observations in our industry. 

### Comparing Java to Other Languages

#### C#/.Net

	-> Similarities
	* Common Language Runtime (CLR):- C# on the .NET plarform is the closest sibling to the Java platform. It's also a managed platform with a virtual machine, called the common language runtime, providing similar benefits to the JVM.

	* Intermediate Language(IL):- The CLR executes so-called intermediate language, which is like Java bytecode. 

	-> Differneces
	* Wider range of language features:- For example, the C# language more frequently introduces new features than Java. Even though C# was created later than Java, it suppresses the Java language in terms of available language features. This does make the language more complex, 
	* Java deliberately moves more slowly in terms of language evolution, favoring simplicity and backward compatibility. 

	* More liberal in breaking backward compatibility:- c# has been more liberal in breaking backward 

	* Originally, .NET used to be a Windows-only platform, whereas Java has been cross-platform from the very start. Nowadays, .NET Core is also cross platform, although the common language runtime doesn't run on as many target platforms as the JVM. Finally the .NET platform is still strongly associated with the Microsoft ecosystem. If your company is already heavily invested in this ecosystem, choosing C# and .NET may be logical. 

	* If not and you want to tap into the world's largest ecosystem of open source libraries and you prefer diversity and options, though maybe at the cost of having to make more choices, then Java is worth considering. 

#### C/C++

	-> Similarities
	* In terms of syntax, Java certainly derives from these languages. 

	-> Differences
	* Both C and C++ are unmanaged languages, which means that you as a programmer do have to care about allocating memory, freeing memory, and not accidentally looking at the wrong part of memory. If you make a mistake, your program may crash hard, also known as SEC faulting. 
	* Managed platforms like Java and C# take away this complexity. In general, you'll have to write a lot more code in C and C++ to implement the same functionality as you would in a managed language. 
	* Low-level: more freedom, also more error prone:- C and C++ give more flexibility and control since they allow you to manipulate memory directly without any restrictions. Since you as a developer need to take care of all low-level details, the code you write is more error prone and can contain subtle bugs that aren't possible in a managed language. 
	* Separately compile for each target platform:- C and C++ compile directly into machine instructions and run without a VM. There are compilers for multiple platforms, but writing portable code in these languages isn't as easy as in Java. 

	*  All in all, C and C++ are a great choice for system-level development, such as device drivers and hard real-time systems, But generally not so much for developing large-scale enterprise applications or web services. 

#### JavaScript

	-> Similarities
	* JavaScript with Node.js: managed runtime:- Combining Javascript with Node.js results in a managed platform somewhat like Java and C#. Javascript originated in a browser, but Node.js provides a standard library and execution environment for JS on the Server. 
	* High-level code:- you can write high-level code without any tedious memory management details.

	-> Differences
	* Interpreted language: no compilation:- JS is an interpreted language, however, meaning ther's no compiler involved. 
	* No static type system:- And unlike Java, it's not statically typed. In practice, this means there's a class of errors that can occur at runtime in Javascript code that simply won't happen with statically typed Java code. Preferring statically typed or dynamically typed languages is somewhat subjective, but in my opinion, preventing errors early outweighs the inconvenience of having to specify types. Besides, I also believe that having types in code can make code more clear. 
	* This is one of the reasons why TypeScript, a language which adds optional typing to JS, has gained so much popularity. 
	* Single-threaded:- JS is inherently single-threaded. Effectively using multicore hardware is possible, but not as seamlessly as with Java's threading capabilities. The goal of these comparisons is to give you enough information to start looking into various options yourself and to as the right questions when comparing. Remember there is not best language and platforms. You decide what fits your requirements and context best.

## Working with Java 17

	-> Java's Various Uses
	Check Tab -> 

	* The way people work with Java has definitely evolved over time, So this journey will take us from d
		* Desktop
		* Enterprise applications
		* Cloud services
		* Android 
		* Language features

### Desktop Java Development

	* Do people still build desktop applications? They're definitely not as popular as they used to be. 
	* Web applications are the norm nowadays. However, Java was born long before the web was widespread, and there are still valid reasons to build desktop applications, For example when targeting offline use cases or when the user interface is sufficiently hard to build in a browser. Interaction with hardware is another reason why people build desktop apps. That being said, Java ships with a full-blown desktop GUI toolkit called Swing. 
	* It offers fully Java-based UI controls - that dont rely on the OS for rendering native UI controls. You can create applications that render and look the same across different platforms. There are multiple look and feels provided to choose from. Some of these look and feels try to mimic a particular operating system's look and feel while others aim for a uniform, 
	* cross-platform look - that doesn't follow a particular platform. Here's am example of a well-known desktop application built using Swing. IntelliJ IDEA is a very popular Java IDE used by many Java developers daily. 

#### JavaFX

	* Ideas on how to create Java desktop applications kept evolving. Somewhere second decade of java, this led to the development of another GUI toolkit called javaFX. With Swing, you can only use code to create UIs through Swing APIs. You can also create code-driven UIs with JavaFX, 
	* FXML - but ther's also an XML-based declarative format for UIs called FXML. This allows the design and the creation of the GUI to be decoupled from the application code underneath. 
	* Advanced controls - JavaFX also offers much more advanced UI components than Swing. However like swing all the UI elements are rendered by Java itself and are therefore cross-platform. 
	* Animations & 3D graphics - JavaFX components aren't just static, they also support animations and effects and hardware-acceleratd 3D graphics.
	* In terms of styling the UI, you can use CSS, which is a popular technology for styling on the web as well, so you can reuse this knowledge for JavaFX applications. 

	* Some really cool examples of what you can achieve with JavaFX can be seen in these applications developed by NASA. Here is what they call their Deep Space Trajectory Design application to visually plan trajectories for missions in deep space. And another ex is this Flight Dynamics Ground System application supporting the operations of the James Webb Space Telescope, which famously replaced the Hubble Telescope. Advanced visualizations are one of the strong points of JavaFX. Until Java 10, JavaFX was part of the standard library and shipped with the JDK. As of Java 11, the JavaFX GUI toolkit is separated from the JDK and is developed in its own project called OpenJFX, a subproject of OpenJDK. This means that it's still available and being developed, it's just not shipped with the JDK anymore. If you want to create a desktop Java application that runs with just a plain JDK, then your best choice is to use Swing. 

	* In general though, desktop application development has become a relatively small niche. Mainstream Java development is geared more towards server-side applications. 

### Enterprise Java
Check Tab -> 

	* Typically, enterprise applications have a high complexity. Remember how we writer Java applications using the Java SE APIs on top of the Java Virtual Machine? This works fine up to a point, but what happens when you start developing more enterprise applications? These typically have web frontends, use transactional databases, integrate with many external systems, perform scheduled tasks, and so on. This goes far beyond what the Java SE APIs offer. So what do you do? You start using external libraries because you don't want to reimplement this functionality time and time again. 

	* In typical enterprise applications, this starts to add up quickly because you need many libraries to address all these concerns. In practice, this means you'll end up with dozens or, if you're unlucky and more realistically, even hundreds of external libraries. And while it may sound like a solution, there are many downsides to this approach. You have to select all these libraries, which costs time and effort, and then you have to make them work together, which can be quite hard. 

	* And finally, you have to manage all these libraries in terms of updates and keeping them working together. Before you know it, things get out of hand and become too complex. 

#### Java EE
Check Tab -> 
	
	* Enterprise Java has emerged as a solution to this problem. it offers an integrated stack of technologies to effciently develop enterprise applications. Java EE, which stands for Java Enterprise Edition as opposed to the Standard Edition that we talked about so far, was launched way back in 1999. We'll learn that this technology got a new name later on, but Java EE is still a widely recognized term, Java EE builds on top of Java SE and offers APIs to interact with databases, build web frontends, apply a uniform application security model, support asynchronous messaging through message brokens, and to handle XML and JSON. This is far from an exhaustive list as there are Java EE technologies dealing with many more concerns. Together these Java EE APIs help developers focus on the actual business logic rather than on supporting technologies. 
	* Jave EE took off in the industry, and many Java developers at some point have used at least parts of Java EE. However, it's good to understand that Java EE is only a specification for technologies and APIs. 

##### Java EE: Application Server
Check Tab -> 
	* There still needs to be an actual implementation of these APIs to run enterprise Java applications, and that's where Java EE application servers come in. 

	* For example from Oracle and Red Hat, both open source and commercial. Every application server offers implementations for the Java EE APIs. You can see a few examples of such APIs here with JPA as an API for persistence, EJB for writing services with transactional business logic, and JSF to develop web frontends. In practice, there are dozens of APIs implemented by a Java EE application server. In turn, enterprise Java app written by developers are deployed to such an app server to run. 
	* The Java EE model was built around the assumption that a single app server would host multiple enterprise apps. Java EE had a good run

##### Jakarta EE

	* But the industry shifed towards cloud-based development and deployment models in the past decade. Oracle decided to no longer develop the Java EE Specifications after Java EE 8 in 2017. EE specifications after Java EE 8 in 2017. Because there's such a large installed base of Java EE applications and developers, the Eclipse Foundation took over from Oracle and they developed the Java EE technologies in an open source project under a new name Jakarta EE. Since taking over from Oracle, there have been several Jakarta EE release. 

#### Java in the Cloud
Check Tab -> 

	* Cloud has been quite a disrupter for the more traditional enterprise Java development model. Why can't you just take your enterprise Java applications to the cloud? To understand this, let's first look at how things used to run. 
	* Typically there would be a data center with dedicated machines running a Java EE application server, such as Oracle WebLogic or Red Hat WildFly, usually in a cluster setup. Then, you can deploy applications to this cluster. Java EE applications are traditionally large and complex applications that are monolithic in their structure. 
	* The application server can distribute your applications across the cluster, but ther are limits to the scalability of the setup. 

	* When developing for the cloud, also known as cloud native development, things are quite difference but usually when developing for the cloud, you adopt a microservices architecture where you split systems into multiple smaller services that can be independently deployed and skilled. 
	* This doesn't happen on a dedicated set of machines in your data center that are running an application server. but instead it happens in the elastic environment of the cloud, for example on Amazon AWS or Azure or Google Cloud. Building such microservices is quite different from the traditional, more monolithic enterprise development model. 
	* There are all kinds of new concerns in elastically scalling cloud environments in terms of security concerns, services discovering each other dynamically to communicate, rapid deployment using Docker containers, and monitoring and tracing across these distributed services, It's a completely different paradigm.

	* New approaches emerged in th Java ecosystem for building these types of cloud native services. These are often referred to as microframeworks where micro refers both to microservices and the fact that these frameworks are typically much smaller than traditional Java EE. 
	* One wildly popular microframework in the Java world is Spring Boot. Spring Boot is built on top of the Spring Framework in combination with selected libraries that offer solutions for problems that you have in the cloud. 
	* A Spring Boot service is ultimately bundled up into a single Java application that runs on top of Java SE. There's no big Java EE application server involved anymore. This model turns out to be very well suited for developing microservices in the cloud. 
	* Spring Boot is arguably the most popular Java microframework, but there are others as well. For ex, there's MicroProfile, which was born out of Java EE. MicroProfile selects a subset of enterprise Java specifications that are relevant for building cloud native applications and add some missing components as well. The benefit of MicroProfile is that you can reuse your Java EE knowledge to now start creating microservices. Other well-known microframeworks are Vert-x and Quarkus, both open source projects led by Red Hat.
	* Even with microframeworks inividual specifications from Java EE, now Jakarta EE, remail relevant and are sometimes used by microframeworks. However, the full Java enterprise application server model, even though it's still widely in use, seems to be on the decline in favor of the microframework approach for cloud native applications. 


#### Java Language Features

	* This won't be an exhaustive overview of all features, but instead a small selection of important features that were added in the versions leading up to Java 17. 
	* Java is an object-oriented language. Concepts like classes, objects, and interfaces have been there since the dawn of Java, yet steadily more functional programming-inspired features have been added to Java in the past decade. 
	* The most prominent ex is the addition of lambdas in Java 8. With a lambda expression, you can define a function without having to declare a surrounding class and putting the code in the method. it looks like this 

	```java
		Function<Integer, Integer> increment = 
		(Integer value) -> value + 1;
	```
	* We declare a variable of type Function that takes an integer and return an integer, and we use the arrow syntax to define the Function. On the left-hand side, we accept an integer parameter called value, on the right hand side and the body of the lambda We increment the value of the parameter by 1. 
	* The incremented value is the result that's returned when calling the lambda. Note that here we only define the function, it's not called yet. Because we've defined a self-contained function, We can now pass this increment function to other methods, and we can even compose it with other functions if we want to. Yet the power of lambdas is best seen when combined with another Java feature, 
	* the Stream API, also introduced in Java 8. Instead of imperatively iterating over collections with for loops, the Streams API allows you to handle elements in collections in a more functional style. An ex is in order, and to make this a bit more interactive, I'm going to use JShell, an interactive console to execute Java code directly.
	* JShell was introduced in Java 9 and is a great way to experiment with Java. Let's start by creating a list containing four items, the integers 1 through 4. By calling stream. we can turn collection into a stream and unlock the Stream API. We can now, for example, 

```command 
	$ jshell
	| Welcome to JShell -- Version 17.0.2
	| For an introduction type: /help intro

	jshell> List.of(1,2,3,4).
			stream().
			filter(i -> i > 2).
			map(increment).
			toList();
	$1 ==> [4, 5]
	$ jshell

```
##### Type Inference

```java 
	URL url = new URL("https://pluralsight.com");
	URLConnection connection = url.openConnection();
	BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
```
	* All types must be known and checked at compile time. In this ex, we as developers must provide the correct types, for in this case local variables. This helps in catching problems should the types not match as expected, but it also adds some redundancy in the code. Looking right hand side assignment the first and last lines instantiate objects using the exact same type as we defined on the left-hand side. 

```java 
	var url = new URL("https://pluralsight.com");
	var connection = url.openConnection();
	var inputStream = new BufferedInputStream(connection.getInputStream());
```

	* You can replace the explicit type declarations for local variables with var. Now the Java compiler will infer the actual type of the variable based on the type of the expression on the right-hand side. Every variable still has a type, but we let the compiler infer it for us based on the context rather than providing it ourselves. 
	* In many cases, by using var, code becomes both shorter and clearer through type inference. 

##### Records

	* Records feature added in Java 16 Records are a special kind of class to be used when all you care about is the data the class should hold. Records offer an efficient way of modeling immutable data classes. Let's say we want define an immutable data class, Product, with four values, a name, vendor, price, and an inStock flag. With regular classes in Java, we need to define a constructor, the fields holding the data, methods to get the data from the class, and we're still not there. 
	* There are several other methods to implement for a well-behaved, data-only class. That's a lot of code for a relatively simple concept. In Java 17, we can do this with records instead.


```command 
	$ jshell
	| Welcome to JShell -- Version 17.0.2
	| For an introduction type: /help intro

	jshell> record Product(String name, String vendor, 
		...> int price, boolean inStock) {}
	| created record Product

	jshell> var peanutButter = new Product("Peanut butter", "ACME",
		...> 400, true)
	peanutButter ==> Product[name=Peanut butter, vendor=ACME, price=400, inStock=true]
	$ jshell

```
	
	* The massive amount of code we saw just before now becomes a one-line record definition, and we can instantiate the record using some actual values to see that it works as intended. By default, the string formatting of the record you can see here shows all fields with their initialized values nicely laid out. 
	* Records offer Java developers a much more concise way to model the main objects in Java applications. 


## The Wider Java Ecosystem

	* Java is more than just a programming language and platform we've seen so far. There's a thriving ecosystem around Java. In this module, we'll see that ther's a vast ecosystem of libraries for Java, boosting productivity for Java developers. Almost all of the libraries we'll look at are open source and freely usable. 
	* Another productivity booster for Java developers we'll explore are the tools available to support Java development, like build tools and IDEs. 
	* We'll also look at some alternative programming languages that are available in the Java ecosystem. We won't have time to look at how all these tools, lib, but let this module serve as an inspiration to start exploring what's relevant to you. It will also help you to recognize some important names from the Java ecosystem. The overview provided in this module is by no means exhaustive, but it will give you a good feel for the prominent tools, libs, and languages that are available. 

### Spring Framework
Check Tab -> 

	* Let's first have a look at a lib that single handedly changed the way enterprise Java development is done, Spring Framework. Boot as a modern microframework to build microservices, but things started way earlier when around 2002, Spring Framework emerged as a contender to traditional Java EE development. At the time Java EE's programming model was regarded as heavyweight and Java EE itself was considered as a slow moving technology due to its extensive specification process. Spring arrived on the scene as an alternative, supposedly lighter weight approach. Ever since that time, Spring has grown in popularity and is widely used for Java App dev.

	But what is spring?

#### Spring: Dependency Injection
	Check Tab -> 

	* At its core, Spring is a dependency injection container. so let's zoom in on what dependency injection is. Dependency injecion is a form of inversion of control. Think of the Hollywood principle, don't call us, We'll call you, but applied to Java code. What does this mean in practice? 
	* Normally, if you start with a single class, it usually needs other classes to do its work. Let's say, for EX, that this LoginService needs a UserService and AccountService class. The LoginService class itself could instantiate the other classes and start using them. That's straightforward Java functionality, so what's the issue here? 
	* By having the LoginService class directly instantiate these other classes, there is now a tight coupling to these classes. Using alternative implementations of these service classes now becomes hard since the LoginService class depends on these exact implementation classes. There's no decoupling or abstraction. 
	* This, in turn, makes the LoginService harder to test since it directly uses the UserService and AccountService classes without any ability to substitute dependencies with test versions or mocks of these classes. This is where Spring as a dependency injection container steps in. Spring allows you to invert the dependencies. Rather than LoginService instantiating and using UserService and AccountService directly, the Spring container is now responsible for instantiating all classes, and Spring provides the dependencies to LoginService. This approach decouples LoginService from the 2 other classes, especially if you also introduce a Java interface between the concrete implementation of UserService and AccountService and their usage within LoginService. 
	* But don't worry if this goes a few steps beyond your current understanding. Crucially, injecting the dependencies means that when testing LoginService, you can provide alternative implementations or mock implementations of these dependencies, Making the code more testable. Spring, in its responsibility as a dependency injection container, wires together the classes of you application based on instructions you provide. 
	* These instructions can be provided either as annotations on your code or as explicit wiring configuration code or even as external XML configuration if you really want to. But, you probably shouldn't nowadays. For now, just take away from this explanation that Spring helps you decouple classes, which makes your life easier in many ways. 
	* Using dependency injection has proven to be a solid way of structuring Java applications, leading to code that is flexible by making classes more loosely coupled and more testable. Addtionally moving the responsibility for instantiating and wiring classes to a dependency injection container like Spring also allows Spring to inject code between these wired classes to address cross-cutting concerns such as security and transactionality,
	* Spring Framework has grown to become more than just a dependency injection container over the years, it features a web framework called Spring Web MVC and more recently also Spring WebFlux as a more modern alternative web framework. Spring also integrates many other libraries from the Java ecosystem, making them easy to use within the Spring dependency injection container. Spring Framework lived up to its promise and surpassed enterprise Java in popularity. Ther's a high chance you will encounter Spring when working with Java, but there are other Java libraries out there as well.

### Other Popular Java Libraries
Check Tab -> 

	* Working on Java applications, you're bound to encouter many different libraries. There's a library to help you with virtually any task you want to implement. You pick and match these libraries to tailor your application's needs. 
	* Use the names you see as a starting point for further exploration if you want.We'll start with 2 libraries that are not used directly in production code, but instead to test Java code. 
#### JUnit
	* JUnit is the most popular library for testing code in isolation. You can easily write unit tests by just annotating a method with Test. 

```java 
	CalculatorTest.java
	public class CalculatorTest {
		@Test
		public void testAddition(){
			Calculator calc = new Calculator();
			int calculatedAnswer = calc.add(1,2);
			assertEqual(3, calculatedAnswer);
		}
	}

```
	* Now the JUnit library takes care of running all tests and reporing on the results, whether it's inside an IDE, as shown here, or as part of an automatic build script.
	* Unit testing is adopted by virtually all Java development teams nowadays. A closely related popular library is Mockito. In our simple unit test example, the Calculator class has no other dependencies, but if the class you want to unit test itself has dependencies on other classes, Mockito allows you to switch out the real implementation of these dependencies with a mock dependency. Throuch such mocks the developer has full control over all the interactions the code and the test has with its dependencies, making it easier to test as cases and faultly scenarios. 

#### Data Persistence
Check Tab -> 

	* Hibernate is a widely used library for data persistence. It allows you to map Java objects to tables in a relational DB by providing just a few mapping hints on classes for the library to interpret. Using such an object relational mapping library, you can store and retrieve Java objects from a relational database easily. 
	* Hibernate builds on top of the Java Database Connectivity API that's part of Java SE. By offering a higher-level abstraction, it saves developers from writing a lot of boilerplate JDBC code for common database persistent scenarios. 
	* Hibernate also implements the Java Persistence architecture specification, which is now part of Jakarta EE. 

#### JSON Processing
Check Tab -> 

	* But When writing microservices you can't really avoid dealing with JSON serialization and deserialization. In the Java ecosystem you have the choice between a few battle-tested JSON libraries that help with mapping between Java objects and a JSON representation, and back again. 
	* Jackson is a common choice, and there's also Gson, developed and open sourced by Google. Last, there's JSON-B, which stands for JSON binding. It's part of Jakarta EE. Any of these libraries allow you to take plain objects and turn them into JSON, and vice versa, with a very small amount of code. 

#### Apache Commons

	* Another name you'll encounter often in the context of Java libraries is Apcahe. Apache is an open source foundation which hosts many Java libraries. There are many Apache utility libraries, which they call Commons libraries, to help everyday coding tasks. 
	* There's Commons CLI to make it easier to create Java command line apps. There's also Commons IO, which helps you to deal with various input and output tasks. And there's for ex, Commons CSV to work with comma separated value files. And there are many more. You can find them all at commons.apache.org. 
	* Apache also offers a widely used HTTP client library. since traditionally Java did not provide a great API for that out of the box; however, as of Java 11, Java also has a modern HTTP client API, and the need for using external libs to do HTTP calls has decreased. 

#### Logging
Check Tab -> 
	
	* Every serious Java application also needs logging to ensure you can monitor he application well and can troubleshoot issue occurring in production. There are several high-performance logging libraries in the Java ecosystem the you can use, for ex Logback or Log4J, which by now is quite infamous for a large security incident around Log4J which happened in early 2022. 
	* There is also commons logging which, as expected, comes from the Apache Founcation. As often happens when working with Java, you need to choose between great alternatives. To make it easier to switch between different logging implementations, you can use SLF4J, which stands for Simple Logging Facade for Java. 
	* This way, you can code against this unified API and swap out logging implementations underneath if so desired. This pattern of having a single unified API with multiple competing implementations is quite powerful and similar to what we saw on the enterprise Java site with Jakarta EE as a specification, which various open source projects and vendors implement. As you get deeper int the Java ecosystem, You'll find out there are many more high-quality libraries available. 
	* For Ex, to do reactive programming with Project Reactor, or Akka, create high-performance network applications with Netty, employing effective caching strategy with Caffeine inside your app, or in a distributed manner with Hazelcast or Ehcache, and the list goes on and on. When using Java, there's always a library that has your back for something you need to achieve. 

## Tools

	* But if you are going to develop a real Java applications, there are some tools you should master that streamline the java development process. Well look at IDEs and build tools as the most important tools to master for a Java developer. 
	* Even though Java source code is just plain text, writing Java code in an integrated development environment instead of a text editor is much more productive. For example, it gives you features like syntax highlighting, clearly distinguishing different elements of the source code, to be fair most editors outside of IDEs offer this as well, the beyond that an IDE understands the structure of your code and helps you navigate quickly between related parts of your code, including relevant documentation. 
	* While writing code, an IDE will point out compilation errors and type errors without having to invoke the compiler yourself every time. Additionally when writing code, the IDE offers you intelligent autocompletion based on the context so that you don't have to know all APIs by heart. 
	* Taking this a step further, IDEs also provide the capability to refactor code, that is to automatically rewrite code in a structurally different way while preserving the semantics. Refactoring is a powerful practice to incrementally improve code. a good Java IDE also helps with compiling and running your application inside the IDE. And on top of that, it supports debugging code while it's executing. 
	* Most debuggers integrated into IDEs allow you to set breakpoints and inspect the current state of variables all in the context of the source code of your project. 
	* There are 2 widely used IDEs among Java developers, IntelliJ IDEA and Eclipse. The screenshots you've seen so for were all from IntelliJ. JetBrains offers IntelliJ as a commercial Java IDE, but they also offer a free and open source version called the Community Edition. 
	* Echlipse, other hand is fully developed as an open source project through the Eclipse Foundation. That's the same Eclipse Foundation that hosts the Jakarta EE project.
	* Which IDE choose the most important thing is to learn its features thoroughly, preferably including keyboard shortcuts as this will be huge productivity booster. 
	* IDEs are great tools for writing and building code on your machine, but as you collaborate, you can't rely on the configuration of a single developer's machine to create production builds of your application. That's where Java build tools come in. Their goal is to describe the steps required to build and package a full application so that the builds can be executed both on developer's machines, as well as on continuous integration servers.

### Build Tools

	* A build tool helps you define repeatable builds, which means that different people in different environments, given the same code base, can all produce the same production builds of an application. 
	* A build tool ensures the Java code gets compiled, test are executed, and code is packaged for deployment. Furthermore Java build tools also help you modularize your application code base. When applications get larger, you often want to split them into submodules or subcomponents that can be built independently. 
	* Using the build tools you can define these modules and express dependencies between your applications' modules and, just as important, also dependencies your code has on external libraries, 
	* Java build tools also help in downloading such dependencies for use in your application's build. There are 2 major build tools in the Java ecosystem, Maven and Gradle.

#### Maven

	* Maven is the most widely used build tool in Java. With Maven, you describe your builds in an XML file called pom.xml. This XML build description is declarative in nature, meaning you don't script individual build steps, but tell Maven about the end result you're after, and Maven will then figure out the steps to get there and execute them for you. 
	* Maven makes many assumptions about defaults in the code base, so you don't have to spell them out. Maven assumes a standardized directly layout for Java code bases that looks like this where the main application code is separated from the test code. Because of all these defaults and the fairly rigid structure of a pom.xml file, most Maven-based Java builds look quite similar and are easy to get started with. 
	* As with Java IDEs, there's more than one popular build tool. The second most popular Java build tool is Gradle. The biggest difference with Maven is that builds are not specified in the declarative XML formats, but instead using the Groovy scripting language.

#### Groovy

	* Groovy is an alternative language running on the JVM, and we'll explore the concept of alternative language after looking at build tools. By employing a full programming language to create build scripts, Gradle offers more flexibility than Maven. This flexibility comes at a price since it can lead to less uniformity across builds and potentially increased complexity. 
	* Gradle does offer incremental builds so that only newly changed code will trigger build steps in subsequent builds as a performance optimization, something that Maven at the moment doesn't offer. 
	* Whether you use Maven or Gradle, both tools help in managing external dependencies for your builds. There's huge publicly hosted repository of Java libraries called Maven Central that is used by both tools for downloading any library to be used in building an application.

	* As a developer, you only have to specify the right coordinates. Here's what it looks like when using Maven. Inside your POM file, you can add a dependency and Maven will take care of finding it on Maven Central. All you need to provide is a group ID, which is like a namespace, the artifact ID, which is the name of the library, and the particular version of the library that you want to use. Maven or Gradle then downloads the right artifacts for use during the builds. Even better, any transitive dependencies of each dependency you specify will be retrived as well. With the Java build tool and Maven Central, you never have to manually locate and download external dependencies again. 

### Alternative JVM Languages 

	* With Java source code compiling to Java bytecode, which in turn runs on the JVM. There's actually no reason why other languages wouldn't be able to compile to bytecode as well and run on top of the JVM too. That way such alternative languages can focus on designing a different language while taking advantage of the existing managed runtime environment that the JVM offers.
	* Because these alternative languages compile into Java bytecode, they can be made interoperable with existing Java libraries that also ship as bytecode so that users of the alternative language can tap into the vast ecosystem of Java libraries we discussed earlier. 
	* What are some of the reasons for people to choose alternative JVM languages? One of the reasons has to do with developer productivity. Java is a language that has evolved over multiple decades with many associated compromises for the sake of backwards compatibility. If you create complete new programming language you're not burdened by such concerns and can offer a completely different experience. Also, we learned that Java is optimized for readability, 
	* but some people prefer more concise programming languages because they believe their teams can be more productive in those languages. Another reason for choosing alternative JVM languages is that those languages can offer different programming paradigms. Object-oriented programming as spearheaded by Java is no longer the only game in town. Different approaches, such as functional programming, are gainging popularity as well.
	* Another ex of a different paradigm is making a language dynamically typed as opposed to Java's static typing. 
#### Scala

	* One well-known alternative language that fuses object-oriented programming with functional programming is Scala. It's very different language than Java, both syntactically and in terms of features. 
	* Yet the Scala compiler takes Scala source code and turns it into Java bytecode. Scala, like Java, is a statically typed language; however, it has much more extensive type system in order to support both advanced object-oriented features and the functional programming features. The extensiveness and advanced features of Scala can be a doubl-edged sword. 
	* When this double-edged sword is wielded by seasoned developers, Scala can be great to work with. Scala is often perceived as having a very steep learning curve. Also, the compiler can get quite slow on large code bases due to all the features that the language supports. 

#### Kotlin

	* Kotlin came after Scala as a more recent addition to the collection of JVM languages. its goal was not so much to be a multiparadigm language like Scala, but to rethink the Java language without backwards compatiblity constraints. Kotlin is created by JetBrains, the same company that creates IntelliJ, the Java IDE we discussed earlier in this module. 
	* It's fully interoperable with Java code, even more so than Scala, Kotlin is first and foremost a very pragmatic language, offering useful features like null safety and data classes, which ultimately inspired Java to add the records feature we saw before to the language. 
	* Kotlin started really taking off in 2017 when Google officially endorsed Kotlin as the language for Android development. Another interesting feature is that Kotlin, besides compiling to bytecode, also compiles to other platforms than the JVM, like the iODS and Android mobile platforms, but also to the Web platform. 
	* That means by writing Kotlin, you can share code between the browser and the back ends or between the mobile app and the backends, which can be very helpful when building applications that span multiple platforms. 

#### Groovy

	* One of the first alternative JVM languages that was widely used is Groovy. Groovy is a dynamic scripting language for the JVM and is also part of Apache Being a scripting language means that the source code is interpreted at runtime rather than compiled upfront. In that sense, Groovy is similar to Python and Ruby; however, you can also optionally Groovy code to bytecode using a Groovy compiler. 
	* Groovy is dynamically typed, unlike Java, which we know is statically typed. In Groovy, you don't have to provide types in source code, making the language more flexible, but also less statically safe because you don't have a compiler anymore to type errors. Therefore, at a later point in time. Groovy got an opt-in type system where a developer can optionally add type annotations to Groovy code. 
	* Groovy can then use these type annotations to find any type-related problems. The Groovy language is somewhat more concise than Java, but its syntax and feel is still very close to the Java language. 
	* Groovy is often introduced into code bases in addition to Java code, for ex to write tests for existing Java code in a flexible manner. That's because Groovy works very well in conjuction with existing Java classes. There are dozens of other JVM languages, but you've now seen three very different, but popular ones. 
	* The 3 languages you've seen have their own considerable communities, but in the end none of them are as widely used as the Java language itself. Many of these alternative JVM languages have inspired changes in the Java language. It's actually a good thing for both the Java language and the Java platform to have these alternative JVM languages to ensure the Java platform as a whole keeps moving forward. 
























































