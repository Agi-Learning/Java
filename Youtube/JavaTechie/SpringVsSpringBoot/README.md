# Spring vs Spring Boot

## Spring Framework

* String is one of the most widely used Java frameworks for building application for the Java platform.
* It aimed to simplify the Java doubled development and helps developers do more productive at work.
* Unlike other frameworks, bring focus on several areas of an application and provides a wide range of features.
* One of the major features of the stream framework is dependency injection. It helps make things simpler by allowing us to developing loosely coupled application.

## Spring boot

* While the spring frame of focus on providing flexibility to you, spring boot aims to shorten the code length and provide you with the easier way to develop publications with augmentation of configuration and default codes and spring boot shorten the time involvement in developing an application.
* It helps create a standalone application with less or almost zero configuration.
* Auto configuration is a special features in springboard. It automatically configures a class based On the requirements.

## Benefits of the spring boot over spring

1. Dependency resolution
2. Minimum configuration
3. Embedded server for testing.
4. Bean auto scan
5. Health Metrics

## Payment service

1. Dependency resolution

* And resource where I use spring with hibernate integration. Ok, let me show you the form .xml. Here, I add the spring pour on text transaction over a web and web. Bbc, Then I add all the hypernat related annotation. Sorry, the dependency, right? So first I need to identify, what are the dependency I am going to add? Then I need to verify the version, whether it will match or not. String 4.3 then hibernate. I am using four E. That is why it is the valid dependency version. If you will do the like higher or lower, then there will be no vapor compatibility, dependency conflict.

* But if you will go to the spring boot application, I create The same application is springboard. It will go to the palm dot xml. The only dependency I add to achieve spring webcam dc features, I added web to integrate with persistence. I added data jpa. So this data gpu will support for Vibernet also. So only two dependencies I added to work with a string, mdc application, right? And the main advantage is here. I didnt mention the version here. So we no need to worry about the dependency version. So I will show you. this is the spring boot application. So while I am adding the parent also currently I am using the parent version as 2 1 .3. So based on. so based on this parent version it will add the corresponding spring drummer related dependency and persistence related dependency. So let me show you If you observe your The dependency spring up is 5%. Means internalities using spring 5X. And if you will form the hybran net, hibernate common annotation, even it is internally using the I 1 at 5. So all the required dependency, it will add by just spring boot. Only I added here web and jpa. But the corresponding dependency, you can see in our wind library So that is what the advantages in spring hook over spring. The first one is dependency resolution. We no need to worry about the dependency. Just add the work and jpa. Then you can happily play with spring with any database integration, any persistence integration. So come to the next point. The next one is minimum configuration

2. Minimum configuration

* Ok so if I am using string with hibernate, I need to enable the data source, then session factory, then. I need to enable the transaction all those top and I need to mention the beam to scan, like components, scan everything I need to configure in my spring bin configuration file. But in case of spring boot, those configuration are not required. Only add few properties in application that properties file. It will enable all those stuff by internally using spring boot. So let me show you the so on. First example, we are using spring with hydronate. And the configuration we mentioned here. Okay, data source then session factory, then all the hibernate related stuff, then transaction manager. And if you'll come to the spring based servant, which specify your component scan and manually, we are enabling the mvc and transaction. So this configuration stop is a bottom for a developer because it is difficult to remember the configuration. This is a small application. That is why adding data source and session factory. So if it is a real time application, then I need to add few more configuration related top here. So now let us understand in string how we can optimize this configuration related stop.
* Come to the spring boot application. Same spring with persistence configuration I need in my spring boot I can manage in my properties file. So this is what my data source driver you are a leisure name and password. And this is what my hibernate related stock. So if I will add these properties, then spring boot internally handle the sesame session factory and entity manager, whatever the persistence will So in case of spring good, you don't need any xml file to configure those top that can be handled by application under properties or application dot yml file. Now come to the next point

3. Embedded server for testing

* Suppose I am going to test my Drink application. Then I need to add the wire in any additional or external server like Tomcat JBOS or web logic. But in case of spring boot spring good provided internally on embedded trunkcare solver. So let me show you that. So this is what my plain spring application if I want to round this application I need to run on server. That is my thumbcare. 8.5 ok, This is how we can run our spring application. So let me stop this. I just want to show you here how we can do the embedded like how we can run the application in server. So this. is how you can run the spring tremor application If you come to the spring boot, let me stop this fast If you'll come to the spring boot there will be one main class It annotated arthritis, spring boot application with main method. You can directly. Ronaks Java application. There is no server. It will run on your embedded tunque. Ok so you can see here. Tomcat initialization with 8080. This tomcat server itself provided by spring boot and that is embedded to our spring boot So come to the next point
*

4. Been auto scan.

* As I showed you You know what? Spring application Manually we need to enable the components current. Let me show you Contest colon components can face vacuous then I provided the root package of it. Then IOC container rules scan my all the beans. But in case of spring food, let me show you. Can you take these all the files different files? Yeah. But in case of spring boot, you can enable the bin scan for Oregon. We can enable the component scan by adding. Components can annotation. You can see here components scan annotation by providing the case package. But if you do not want to use this annotation component scan, then you need to follow the packet structure. Let me show you the package structure. That is why I created one more example. If OK, this is what the packets are saying. So this is my route package. Com Javerteki, Micrometer, Dot api. And this is what my controller load. I wrote one test method to check whether it is working or not. If you observe the my fast packets com Javerteki micrometer api, where I have the main method, ok? And the second. and the second package torture is completely different. Com.Javaticket.com. Ok so I am showing just let me run this. Ronat Java application, it will run on embedded tomcat provided by spring boot. Ok so our application is often put 8080. Let me hit this url, local host, 8080. We are getting 404. Means the url is not found. That means ioc is unable to scan my controller either. You can do one thing here, you can enable the component scan using annotation, or else you can follow the package structure in spring boot Change this package to Dot controller. Up to com Javediki Micrometer api is my base package. Then apart from that, add main catheter. We can say the soft pack is right. This is what my controller. Let me stop this. Similarly, if you want to create repository or down First add the base package, then add the sub package, like the or similarly For motel or utility, you can follow the same utility. Then.com. So what I am going to explain here up to this is my base fake case. Then the next one is my soft package. If you follow this structure, then we donate to manually Components can two like scan our beam, right? So now we change the packet structure. Now let me run this application. The application And it is not taking most time to boost our don't get solved. Now let me give this url again. Now we are getting the response, right? So this is what the autoscan provided by string 2. Either manually scan using component scan or else follow the package structure, right? So the next one is

5. Health metrics.

* So here This means I developed an application. What are the thread down? What are the memory occupied? And what are the memory for like kind of gc log? Everything I can manage with the help of this health matrix. So in case of spring boot, this health matrix features, we can achieve using the actuator. So there is one more concept in springboard. That is the actuator. Eating that actuator, we can monitor our application. But in case of spring framework that Tune into two with the help of either you can add the customized framework to achieve the health matrix or we can depends on any 3rd party so that. I can show you here, but this health matrix absolute concept already I have uploaded video in my spring book playlist. You can find it. Ok This is what the main thigh features. That is why people are using spring boot instead of spring tremor. So everything we covered with example go you can understand it.