# Single Sign-On with Spring Boot & Okta | OAuth 2.0

* Now a days everyone want to secure their web application and they want to enable single sign on features. So what is this single sign on? Why everyone want to enable this single sign on features in their web application. Let's understand this single sign and concept with one useful example. Let us say I logged into facebook and I clicked on messenger so it should not ask me to re login means by clicking on any event I should not get a login perform correct. Single Sign in means one time login to the application. So let me show you one real time example where this single shannon concept already implemented. So here I logged in with my gmail account. So if I will click on this I can see bunch of product provided by google as I logged in to my gmail account. So if I click on this YouTube it should not ask me to rel again. So if you observe here it got sync with my gmail account and it got auto logged in. Similarly I can use another product let's say I am going to use this map. So again it will auto logged in from my gmail account. This overall feature is called single sign on. Once you logged in to product if you are going to use another features of that it will not force you to login OK. So same kind of features we are going to learn today. How we can implement this single sign on features in our web application. So for that we are using Octa authentication server who will enable single sign on for us. We just need to write few configuration and from our application it will enable this single sign on features. And how these Octa server internally work and how he provides single sign on you will learn made of this building. Let's quickly create a PIN code application to understand how we can enable this single sign on using Octa and Oauth 2. Right. Let us get started. Let's go to Eclipse and create a Springboard project. Here click New Spring Starter Project. Click Next and let's add the dependency. Will add your dependency. Spring Security here, so let's add that. Along with Spring security we need Octa dependency because from our application we are going to integrate with OCTA authentication server. And one more dependence you need Auth 2 which is provided by spring cloud so click on finish. Yeah, so application imported. Let's go to pawn.Xml. In **** XML, let's change the parent version 2.1 .4 and we are going to change the version of our Octa structure. This is not the compatible version to work with Spring 2.0 OK. So let me add the actual version which is 0.6 .0. Let me paste here. Yeah, let's update the project. Yeah, so we are good. There is no compilation error. Let's go to our main class. In main class I want to expose one recipe so annotate this with other rest controller. So let me write on REST endpoint to welcome the user. So once user logged into my application I want to display some welcome message OK. So let's write that. Welcome to user. Return some message so the user who is going to login I want that username so I can get that username from principal object which is provided by Java security OK. So what I can display here? Then the username. principal.gatname. And I want to welcome to Java Tiki. So let's annotate this with advert gate mapping. And I am specifying the default model. We created this REST endpoint and we want to enable single sign on in our application with the help of Spring Cloud Auth 2 and octop right? So that's why you need to unenable. Both two SSO. We need to annotate this at the rate enable both 2 SSO. So we are good in our project. So we created a project where we declare on REST endpoint to enable single sign now. But this single sign on features will enable by Octa server right? So for that you need to create a 15 hour Octa server. Let's go to browser and we'll create one account in our Okta authentication server. So if you have already account in this after authentication server you can go for this login if you don't have let's sign up for it. Just need to provide your mail ID so I'm giving Java key for reward at gmail .com give the first name. And last name then choose a company name so we can choose anything like Java tech. Youtube. OK, so click on Get Started. So AKTA will send one email with default password. Go to your gmail account. So you need to verify that go to the gmail we got the mail. This is what the default password. OK so let me copy this password. Click on Activate my account. So you need to give your mail ID for. Key for you @gmail.com. Then give the default browser click on sign in. Yeah, here you will get to enter a new password. So let me give the password. Now you can choose any of your Security question OK so as of now I'm giving nothing. You can choose the image here. Let me choose this one. Click Create My Account. So it created our account in Octave authentication server. So we need to create a application here. So click on this application. Click on Add Application then choose this web option. Click Next. So you can specify your URL. So let me give HTTP local host 9090. And this is also I want to give 9090. Give the earlier login right? This is what my base urine and this is what my default URL for login. Then go down and click on done. We created the application in our OCTA authentication server and it provided us client ID and client secret. These two things we need to configure in our application to communicate from Springboard to October OK. So let's go to our application. Go to Application properties. Here you need to specify the client ID and client secret. Let me specify Octa dot auth 2 client ID and you want. Walk to client secret. And you want the default URL of my domain, so after dot. 82. Dot Yeah. Apart from that we changed the server port to 9090 right? This is what we mentioned in our Octa server. Which is local host 9090. So let me change the port in my application as well server dot port 9090. Now we can copy the client ID and client secret from our browser. So let me copy that, copy the client ID and paste here. Similarly, let's copy the client secret. And I want this is your right? So what you can do go to the browser. Click on this API Authorization Server. You will find the default domain for your authentication server. So copy this. Auditing your properties. We need to add here bin definition over right? So specify that spring dot main, yeah. So we created our application, we enabled single sign on and we configure with authentication server by giving client ID, client secret and Azure OK and. Hey, Cortana. Put 9090 and we override allow bin definition to true. So what we can do? Let's run our application. Yeah, so application is up on port 9090. So let's go to browser and try to hit this REST endpoint. OK so let me open the browser type your local host 9090. So you can see here we. Are getting from the okta servo. Here we need to provide our username and password. Same username and password we need to provide which is set at the time of sign up. So let me give that jabber tiki for you at the rate gmail.com then give the password. Now click on Sign in. So you can see here the response rate higher than the username and welcome to Java Ticket. Same message we set in our controller. And we are getting the username from this principle object right? So how it internally work? Once a user send a request to my application then from my application that request will delete to application server and as you specify the client ID secret ID it will validate the username and password in Octa server itself. If the username and password is correct then we will get the response. So in this example we didn't store our credential in our local machine or any database. It will take care by Octa server and it will provide us the single sign on features. Now if I will re login it, it won't force me to give the credential right? You can see here. Three times I logged in, but we're getting the response. It didn't show the pop up for login right? Yeah, so that's it about this particular video guys. Thanks for watching this video.


📄 README.md
# Single Sign-On with Spring Boot & Okta | OAuth 2.0

Now a days everyone want to secure their web application and they want to enable single sign on features. So what is this single sign on? Why everyone want to enable this single sign on features in their web application.

Let's understand this single sign and concept with one useful example. Let us say I logged into facebook and I clicked on messenger so it should not ask me to re login means by clicking on any event I should not get a login perform correct. Single Sign in means one time login to the application.

So let me show you one real time example where this single shannon concept already implemented. So here I logged in with my gmail account. So if I will click on this I can see bunch of product provided by google as I logged in to my gmail account.

So if I click on this YouTube it should not ask me to rel again. So if you observe here it got sync with my gmail account and it got auto logged in. Similarly I can use another product let's say I am going to use this map. So again it will auto logged in from my gmail account.

This overall feature is called **single sign on**. Once you logged in to product if you are going to use another features of that it will not force you to login OK.

So same kind of features we are going to learn today. How we can implement this single sign on features in our web application. So for that we are using **Okta authentication server** who will enable single sign on for us. We just need to write few configuration and from our application it will enable this single sign on features.

---

## Create Spring Boot Project

Let's quickly create a PIN code application to understand how we can enable this single sign on using Octa and Oauth 2. Right. Let us get started.

- Let's go to Eclipse and create a Springboard project.
- Click New Spring Starter Project → Next and let's add the dependency.
- Add **Spring Security**, **Okta dependency**, and **OAuth2** from Spring Cloud.

### `pom.xml` (Version Updates)
```xml
<!-- Parent version update -->
<parent>
    <version>2.1.4.RELEASE</version>
</parent>

<!-- Okta dependency update -->
<dependency>
    <groupId>com.okta.spring</groupId>
    <artifactId>okta-spring-security-oauth2</artifactId>
    <version>0.6.0</version>
</dependency>

Main Class
@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class Application {

    @GetMapping("/")
    public String welcome(Principal principal) {
        return "Welcome " + principal.getName() + " to Java Tiki!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


We created this REST endpoint and we want to enable single sign on in our application with the help of Spring Cloud Auth 2 and Octa right? So that's why you need to annotate with:

@EnableOAuth2Sso

Configure Okta Account

Go to browser and sign up for Okta Authentication Server

Create account

Add new application → Web → supply redirect URLs

http://localhost:9090
http://localhost:9090/login


Okta will generate:

Client ID

Client Secret

Issuer / Domain

application.properties
okta.oauth2.client-id=YOUR_CLIENT_ID
okta.oauth2.client-secret=YOUR_CLIENT_SECRET
okta.oauth2.issuer=https://YOUR-OKTA-DOMAIN/oauth2/default
server.port=9090
spring.main.allow-bean-definition-overriding=true


Copy values from Okta dashboard → Applications.

Run and Test

Run app → open browser:

http://localhost:9090


You will be redirected to Okta login page, enter credentials, and then response:

Welcome {USERNAME} to Java Tiki

How It Works Internally

User sends request → Spring Boot

Spring Security sends request to Okta Auth Server

Okta validates credentials

On success, user is authenticated & SSO session starts

No need to login again on repeat visits

Summary

✔ Implemented OAuth2 + SSO with Spring Boot
✔ Integrated Okta Authorization
✔ Configured client ID / secret / issuer
✔ Created secure login flow

Thanks for watching this video. 🙏


---

# 🎁 Ready to Download?

Would you like me to generate this as a **real `.md` file** so you can download it directly?
If yes, I’ll create and provide the file link. 😊