# Spring Boot Payment Gateway With @PayPal

* Hi everyone welcome to Java Tiki. In this tutorial we will discuss about how to perform payment integration using Paypal. So I will use back end as spring good here and front end as thimely. And this particular integration stop was given by one of our doers. His name is Ravindra and he told me that maximum time is spent to launch springboat and microservices from Java Tiki. And in this example I will use each Paypal account. But no worries guys, I'll show you the step how to create your own Paypal account Azure thanks Ravindra for your support. So let's quickly create a Springboard project to perform this integration stuff. Let's get started. So let's go to Eclipse.  Create a springboard Projecteer click on File New then Spring Starter Project. So let the application name spring PayPal example. Then click Next. So are the required dependency added Lambo, Devtools and Spring Web. So this is what the latest version of Springboot 2.1 .8 click on finish. Yeah so application is imported. Go to your pom XML there is a com. Violation erupts. So let's change the springboard version to 2.1 .4 and then do one maven update. Yeah, so we are good. There is no compilation error, so we are. Red only springboat related dependency like devtools lumbo and springboot webpread stutter. But to work with paper we need to add one more dependency. So let me add the dependency. Go to phone.Xml. So we can add it here. OK. So we created a project and we added PayPal related dependency right to work with PayPal first you need to create an account in our PayPal so go to this type here Paypal developer account. So here you will get option to create a sandbox account. Click on this. So in top you will find login to dashboard. If you have already you know the credential then you can do it or else just click on sign up. So choose the option Your personal account, then click on Next. So you just need to provide your email address and you need to set your password. So I am going to use Ravindra credential but to show you I will create a account here so let me use my own mail ID. Then set the password here. Now click on Next. So you'll find here to add your first name, last name and your address details and your mobile number OK. So let me add this something like let me give this. So here click on agree all the term then create your account. Once you created your account you need to provide your bank details OK. So after provide your bank details you can choose this link card then you will successfully create your account in Paypal developer site OK. So this is what the step you need to follow to create account in PayPal developer account. So already I created one account so. Let me show you the how we can create a application and how we can get client ID and secret ID. So I am closing this. Go to Engansim link, create sandbox account. No. Let me logout here. So again I am going to login with the mail ID which I already created. Jabti Key for you at the rate Gmail .com. And give the password here. Now we created our sandbox account. This is what already I created. So in order to go to this option my apps and credential. So here you will get option to create a application OK. So click on this create app. Then give your application name. Let me give something like test 8eight. Then based on your email ID you will find this default gmail. So chosen this Java ticket for you underscore facilitator at the rate gmail.com then click on this create app. So it created one application with name Test double 8 and here you will find your client ID OK. This is what your client ID and if you go down you will find your secret ID OK. This is what your client secret and this is what your client ID. These two things you need to configure in your application dot properties file. But I am not going to use my own client ID and client secret. I am going to use their client ID and secret ID provided by Ravindra. So let me add those field in my properties file. So go to eclipse, go to your application properties file. Copy paste this. You don't want this timely phone. Just remove it. So in our properties we added all the client ID and secret ID and the paper mode is sandbox OK. So we need to add one config class and there we need to configure this ID and secret OK. So go to our SRC main Java. So I'm not going to create one more package so I will add the config here. Name it like PayPal config. Valuate this with advert configuration. What this annotation configuration and then we need to load these three file means 3 property mode and then client ID and client secret. So go to this config and load these using at the rate value annotation. So you put this value. So now we need to give this to our. People SDK config. OK. So let's create a bin, something like public. Map of string. Give the method name something like. Paper SDK config. Input the map here. So here let's create an object of a map, something like config. Name it like configm app then new host map. So remove this generic. Here we just need to set the mood which we mention in our application under properties field right? So let's add it. Configmgr. Dot put key AJ mode. This Delhi will get from the property side. Let's return the same map. OK. Then we need to create auth token for our PayPal account by giving this client ID and client secret and this move OK so let me create that public. Or cooking credentials, something like that, yeah. So if you observe this path token credential is coming from paper so. Give the method name here. Return it. So here it is asking for client ID and client secret and mode right? So give the client ID here. Then client secret and we need to pass the mode here and that mode we can get from this method right? So what we can do just call this method here? And again, we need to annotate this with the red DIN. Then we need to create object of our API context. So create that public API context. If you observe this API context is coming from paper, right? Do this. Now create object of API context here. And we need to pass the. This authentication token to this API context OK so use this. Call this method. movetoprudential.get access token. OK and then in context we need to set the map context dot set. There is a method configuration map we can call our PayPal this one. You have to call this method. So let me copy paste. Yeah, now just return API context. And handle the exception, so I'm throwing it. OK. So whatever the properties we added in our application properties pile that we configured here right and we get the authentication token by giving the client ID and client secret to our API context. So we created our configuration and we have our main method. Now let's create our controller to perform the payment processing. So create a class give something like Paypal controller. United here are the red controller. OK. So here, let's inject our Paypal service. We didn't create the service class yet, so let me create it. OK. Create a class called Papal Service. Click on finish. And this is my service I need to annotate with other service. Then here we need to inject our API context. Then we need to create two method here one will be create a payment object and another one will be process the payment OK. So let me add these two method. This bacon taste. Limit to API context. So if you observe I have two method here one will be create payment and this payment will take the argument as the amount which you are going to pay and the currency whether it is USD or indian currency and the payment method whether it is PayPal or any other then intent and then payment description and then set the URL. If the payment user is going to choose the cancel then choose this URL if the payment is success then redirect to this URL. OK so if you observe here created amount object and let me show you the input statement this amount pair all the stock is coming from table itself right? So creating amount object then creating Transaction object. I am adding here list of transaction then I am setting my pair who is going to pay then again I am creating payment object and in payment I am adding intent and payer and I am setting the transaction OK then at end I am redirecting to the. Paypal payment so if you observe here this is what my redirect URL OK and this is what my execute payment method it will call PayPal payment processing method OK. So now let's go to our controller. So in controller we need to inject our Paypal service. So inject using autoid. So there is a spilling mistake, so let me change the name. Tables of this. OK so as we are using thyme leaf here I want to pass few couple of input to this payment method from our HTML page. So 1st let me create one home page so for that let me write one endpoint so let me something like home yeah. Return the HTML page whose name is Home OK. So annotate this with gate mapping. I'll give the class. So let's create a HTML class or HTML file with name om. So go to this template new. Then soil. Om HTML. OK so in this HTML we need to add the template. So let me copy paste the template. So here we are using thyme leaves. So let me show you the thyme leaf input. Yeah this is what the thyme leaf. So if you observe in HTML we are just giving the input like total amount and then currency, payment method, intent, payment description. This is what we mentioned in our service right. So if you observe here in create payment this is what the input we are giving. So that input I am getting from my HTML. So I will add this source code link in video description so that you guys can reuse this tool. So let me set this HTML. Now go to our controller. Now here you need to write the method to perform the payment processing OK. So let me direct this oblique string. The method name is Payment. Return some string here. And in this payment as I mentioned couple of field in my home HTML. Like total currency and payment method, intent, payment description all those field I need to pass right? So for that I need to create one DTU so let me create a DTU called order. OK so in Order class let's add the film which we are getting from our HTML, price, currency method, intent and description right. So as we added lombok we want to write Gator setter manually. We can go for this annotation and we can Add all argument constructor. We need no argument constructor. Let us add two steam OK so we are good. Now let's go to our controller again and we are expecting order object to be pass as part of request so. As we are using here MVC, so that's why we annotate at the rate controller right? So here we need to add annotation at the rate model attribute. And give the name that we are giving order. So here we need to call the method from our service right service dot create payment and we need to pass all the input and this create payment method will return the object of payment. So capture it put your controller. Now we need to pass all the few which we'll get from our order object so we can specify order dot price. And again odd of dot get currency. order.getmethod. Then to pass all the few layers right.great intent. Auditor dot get something like description. Yeah, get description. And we need to set these two URL, cancel URL and success URL. So let me add this to URL here. So we can add it here.2 year end success year end will be pay less success and cancel URL will be pay slash cancel OK. So these two URL we need to set here. Let me add HTP. Localhost Denver port 9090. Then this is for. Cancel event right? You can pass this. So let me copy this same unit to pass for our successive hour. OK. So drill through some exception. Let's handle it with tricycles. So we created payment object here. Now we need to get the link to redirect to our paper right? So that link we can get from our this payment object. So for that what I can do I can directly iterate the link. So the link we can find which you getting from our PayPal. So it is something like link or link. Yeah, it is links. And you'll get it from our payment object payment dot get links, yeah. You just need to iterate it and I need to check if. Link dot. Get. OK. Dot equals if it contains the string with name approval URL. Then get that link and redirect to our paper payment API. Redirect. To this link. OK. So if the link which I am getting from payment object contains this string which will be Approval URL then from my application I want it to redirect to. Paper Payment Processing API, OK. And here also I need to redirect right? So yeah, so this is what we need to annotate with gate mapping. And we need to specify the URL same URL which we mentioned in our home .Html file, right? So yeah, the URL will be slash pin go to our controller just specify slash and we specify 2 URL right, success URL and cancel URL. So for these two URL just write to rest controller, repeat. This is what? Let me do this so that I can explain you. So we created one first method who will do the payment by creating the payment object and all the input will get it from our HTML and we set you to URL cancel, URL and success URL and we are getting the links from our payment object and if that link contains approval URL then we are from our application we are redirecting our request to PayPal URL OK and if it is cancel URL then it will redirect to this. So we need to create one more HTML file with name cancel. And if it is successive then. I am invoking service dot execute payment by giving the payment ID and payer ID. So if you go to our execute payment this is what the method we created in our service right? So if the user is proceeding to do the payment or if it is success then this execute payment method will come OK. So that's why we specify the URL HERE SUCCESS URL. And once the payment is success I just want to print it in our console. So I don't want to log here. Remove it. I simply want to print it. seesoundE.get message. And if the response is success I want to print it in my console and here I need to create two HTML for success and for cancel. So I have two HTML. Let me add this to HTML file. So go to the folder. In template I can add this success, HTML. So I just want to print payment is success. Similarly let me add for cancel, HTML. Let me copy paste this. Better to create a new HTML. Cancel dot. So let me get this content. Go to our cancel dot HTML page. Then specify here payment failure something like that OK. So this is what we mentioned in our controller right? If the payment is canceled, redirect to this HTML if it is success, do the payment execute and then return to our success. Right so let me cross verify. Once created controller we created service. It's 2M. Yeah, so I guess we are good. Now let's run our application to test the things is working or not. Soronna's Java application. Let me zoom the console. There is some error. Let me check it. So there is some error in our PayPal config. So go to this yeah so if you observe here we are doing recursive method call. Here we should return the reference right this context of G. So we are good. Now let me restart my server. So if you observe here our application is upon port 9090. Now let's go to our browser. Let me create a new one. Tie Fiery local host 9090 yeah this is what our HTML, home dot HTML. So here I have four product with cost total $10 OK so I had put the value of $10. Now click on currency USD and my payment method is Paypal and intent is sale. Add some description here testing. Let it be testing now. Click on continue to check out. Now it should redirect to our Paypal payment API. OK so click on this. You're getting something 4 not 5 due to the post not submitted. Yeah so go to the controller. I believe we did wrong annotation. Go to our payment controller. Sorry PayPal controller. Yeah so this method have the request body, so this should be POST mapping right? Now let me stop this and let me restart it again. Yeah so again it open put 9090 go to the same browser. Let me refresh this homepage degen add the value USD then payment method PayPal so are some different description here testing payment. Now click on Continue to check out. Now it redirecting internally to our PayPal so here I need to give my email address so this is what provided by Ravindra so I am using it. You can try with your own credential OK. Click on Login. This is where the token it passed from our application. Yeah, so high Pavan then the delivery to this guy OK. So let me go back. Yeah, so if you click on continue, the payment will be processed here. So you got the response right, payment success. So if you go to consult you can get all these information. Let me copy somewhere so that I can show you the proper Jason. So let me cook this in notepad so that. Akhilesh see it in better way. So this is what the payment method people and this is what the user ID and all the information about pair who is going to pay and this is what the transaction details with amount $10. And if you calm down? You can find the payment mode instant transport state is completed and protected eligibility is eligible. Lot of stock will get from the payment objective right? And this is what the address of the user who is paying now. Right so this is what the response will get after payment and as we added one dummy template this is how we are getting payment success response right? Yep. That's all about this particular video guys. Thanks for watching this video. Meet you soon.

💸 Spring Boot Payment Gateway with PayPal

This tutorial demonstrates how to integrate the PayPal Payment Gateway in a Spring Boot project using:

Java

Spring Web (MVC)

Thymeleaf

PayPal Java SDK (Sandbox)

📌 Prerequisites
Requirement	Description
Java 8+	Development environment
Spring Boot	2.1.4 (or compatible)
Maven	Build tool
PayPal Account	Sandbox account for testing
🛠️ 1. Create Spring Boot Project

Dependencies to add:

Spring Web

Lombok

Spring DevTools

If you face version issues, set Spring Boot version manually in pom.xml:

<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.4.RELEASE</version>
</parent>

➕ Add PayPal SDK Dependency
<!-- PayPal Java SDK -->
<dependency>
    <groupId>com.paypal.sdk</groupId>
    <artifactId>rest-api-sdk</artifactId>
    <version>1.14.0</version>
</dependency>

🧪 2. Create a PayPal Sandbox Account

Go to: https://developer.paypal.com

Login → Dashboard

Navigate to: Sandbox → Accounts

Create:

Personal account → acts as customer

Business account (Merchant) → for Client ID & Secret

🔐 Retrieve API Credentials

Dashboard → My Apps & Credentials → Create App → Get:

Field	Value Example
Client ID	AQFK...
Client Secret	EJkx...
Mode	sandbox
⚙️ 3. Configure Application Properties

src/main/resources/application.properties

paypal.client.id=YOUR_CLIENT_ID
paypal.client.secret=YOUR_CLIENT_SECRET
paypal.mode=sandbox
server.port=9090

🧩 4. Create PayPal Config
@Configuration
public class PayPalConfig {

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.mode}")
    private String mode;

    @Bean
    public Map<String, String> paypalSdkConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("mode", mode);
        return config;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    public APIContext apiContext() throws Exception {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;
    }
}

💼 5. Create a Payment Service
@Service
public class PayPalService {

    @Autowired
    private APIContext apiContext;

    public Payment createPayment(
            Double total,
            String currency,
            String method,
            String intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException {

        Amount amount = new Amount(currency, String.format("%.2f", total));
        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        Payment payment = new Payment(intent,
                new Payer().setPaymentMethod(method),
                Collections.singletonList(transaction),
                new RedirectUrls().setCancelUrl(cancelUrl)
                                  .setReturnUrl(successUrl)
        );

        return payment.create(apiContext);
    }

    public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
        return new Payment().setId(paymentId)
                .execute(apiContext, new PaymentExecution().setPayerId(payerId));
    }
}

🏦 6. Create DTO

Order.java

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}

🌐 7. Controller
@Controller
public class PayPalController {

    @Autowired
    private PayPalService service;

    @GetMapping("/")
    public String home() { return "home"; }

    @PostMapping("/pay")
    public String payment(@ModelAttribute Order order) {

        try {
            Payment payment = service.createPayment(
                order.getPrice(),
                order.getCurrency(),
                order.getMethod(),
                order.getIntent(),
                order.getDescription(),
                "http://localhost:9090/pay/cancel",
                "http://localhost:9090/pay/success"
            );

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/pay/cancel")
    public String cancel() { return "cancel"; }

    @GetMapping("/pay/success")
    public String success(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String payerId) {

        try {
            Payment payment = service.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved"))
                return "success";

        } catch (Exception e) { e.printStackTrace(); }

        return "redirect:/";
    }
}

🖥️ 8. HTML Views (Thymeleaf)

📍 home.html

<form action="/pay" method="post">
  <input name="price" placeholder="Amount" value="10">
  <input name="currency" value="USD">
  <input name="method" value="paypal">
  <input name="intent" value="sale">
  <input name="description" placeholder="Description">
  <button type="submit">Pay Now</button>
</form>


📍 success.html

<h2>🎉 Payment Successful!</h2>


📍 cancel.html

<h2>❌ Payment Cancelled.</h2>

🚀 9. Run the Application
mvn spring-boot:run


Visit:

http://localhost:9090/

🎯 Result

Redirects to PayPal

Logs the full transaction JSON

Shows success or cancel page

Example response fields:

{
  "state": "approved",
  "payer": {"payment_method": "paypal"},
  "transactions": [{"amount": {"total": "10.00", "currency": "USD"}}]
}

🎉 Conclusion

You have successfully integrated:

✔ PayPal REST SDK
✔ Sandbox Payment Flow
✔ Spring MVC + Thymeleaf UI
✔ Success / Cancel handling

⭐ Next Options

If you want, I can also prepare similar Markdown docs for:

Razorpay

Stripe

PhonePe

Cashfree

Paytm

Just say: "Next Payment" 🚀

Would you like this packaged as a ZIP / GitHub repo as well? 😊