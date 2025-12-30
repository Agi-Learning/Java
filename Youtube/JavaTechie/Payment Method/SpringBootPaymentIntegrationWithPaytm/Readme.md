# Spring Boot Payment Integration With Paytm | Live Example | Java Techie

* Everyone welcome to Java Tiki. So in this tutorial we will learn how to perform payment integration with Java application. So basically in this demo I will show you payment integration with pay team and we will use back end as Spring boot here. So let's quickly create a Spring boot project to understand more about this integration. So let's get started. So let's go to Eclipse, create a Springboard project here. Spring starter project then. Change the name here something like Spring. Tamen Paytm then change the description here. And integration with KTM. Similarly, we just need to change the package here. Spring Paytm.Api Now click Next. Movie. I am going to add your web dependency and we need dev tools and lumber Finish it. So application imported successfully, go to the pom XML, change the parent version to two 14 then. Let me do one update. Yeah, so we are good. There is no error now. So here we created a spring good project but we want to sync with Pete. So to perform the payment integration with pay team we need couple of input from the pay team like merchant ID, merchant key. So for that we need to go to the Paytm. This is what the integration link. If you have account click on login or else you need to create a new account so already I have account so it will redirect me to my account directly. Then in payment gateway you will find the option to set up payment gateway. So click on this. This is what the merchant ID and secret key for my specific. So this. Two input I need to configure in my springboard project. So go to the application go to SRC main resource. Here I'll create one file called application iml file. So name itlikeapplication.yml. So in application OML I need to pass this merchant ID merchant key along with couple of free. So let me add that so this is what my merchant ID merchant key and channel ID web. So if you observe here this is what the payment sorry paytm URL from our application will redirect to this URL. And then this is what my color once my payment process is success then I want to redirect to this URL so that's why I mentioned here OK. So now I need to create a model class with all these field OK so go to SRC main or root package. Pay team details. So the class name should be paid in details. As we mentioned here. The details will bind all those details in our model class OK. So here we need to Add all the field. So let me add this field. These are the field which we configured in our application dot yml file. Now as we added lumbo you know need to write get a setup we can go for the annotation. I. Then we want all argument constructor. Similarly we want no argument constructor and we want two string. And this is the paytm details is my bin so I want it to be annotated with other component annotation. OK and I want to load the configuration properties. It is present in my application ymail and the directory is paytm dot payment and details OK. Paytm payment and these sandbox so that's what I need to configure here. So we created our Morden and even we load our properties info. OK. So now let's write the control. Let me save this file. So now let's create a controller class. From where we can redirect our request to the paytm server. So let me create a class called. Payment controller. So let me annotate this with other rate controller because I want to use the UI here. So that's why I'm going to use the time lift. So let me add the thyme lift dependence in our pom XML. So go to pawn XML. Here we can add the dependency. So let me add here. Now close it. So here first I want to write a method to display one HTML page. So let me write something like public string home. On my HTML page name is. Let me name it like. Now annotate this with gate mapping. OK so if you observe here. I just want to based on this slash URL I want to redirect to HTML page which is named home. So let me create a HTML page here so in template. I can create your HTML. So name it like home yeah. So here I need to design a form page to pass all those required input like order ID, customer, ID and transaction amount. All those two right? So I have already one template so let me add it here. So add it here. So this is what my form page. So if you observe here I am giving customer ID then industry type channel ID and at the end you can find the transaction amount right then I have the submit button so click on save this. Now go to the control load, we need to inject here paytm detail subject so that we can get all the merchant ID, merchant key all those value right? So what I can do pivot? Paytm details. So inject using auto add. So now write a method so if you observe in our home HTML we configure the URL called. Slash redirect, right? So let me show you that. So yeah so if you observe here I specify one URL right. So once someone will click on this form this URL goes to my controller. So for this URL I will take all the input like order ID, customer ID and then same input I need to redirect to the paytm server. So for that I need to write a controller here. So let me write a method something like oblique stream page redirect. OK so I guess I missed one thing. I added the HTML but I didn't add the CSS file for it. So let me add that in static folder. So I added this tile CSS to make my HTML more graphics. So that's why I added this CCS file. So now we are good we can proceed with our controller. So here I can specify the URL gate mapping. Better to mention POST mapping as we have request input. Then I need to specify the same URL here. This is what the normal MDC fluoride. So here I need to pass the couple of field like customer ID, transaction amount and order ID. So I have that template better let me add so that I can explain it. So let me add it here. So get up to Juman 's, yeah? So let's input the model and give. So if you observe here I specify the URL and from input as part of my URL. I was expecting this customer ID transaction amount and order ID and this is what my paytm details so its not taking let me check so it should be lower case. So if you observe here this is what I make the upper one. Now there is no compilation error so let's go to the code. So if you observe here I created model and view object and from model and view object I am redirecting my request to this paytm details get paytm URL. So if you observe this URL. Will be our. Which we mentioned in our application dot IM. This is what the. Paytm you are right so from application with all these input we are redirecting our request to this paytm you are and that's why I created one map here parameters and from paytm details I am extracting all value and I am keeping in our parameter map and here I need to specify my mobile number, email order ID, order ID will get from the request input then transaction amount and customer ID. These two field also will get from the. Request input here. At the end I am calculating. Cliting gate checksum so we need to add one more dependency which is pay TM checksum dependency to calculate the checksum then that checksum I am adding in our parameters at end all the input I am giving to the model and D object right. So first let me add the checksum dependency so go to file. Already. So go to our project, right click, go to build path. So here choose add external jar. So I guess yeah it is in desktop. Click on this open. Apply and close. Click on this open. A play and close. So now we need to create my Method OK. So let's generate the checksum here. So for that we can take the help of check some service help or something like that. So let me type it. Yeah, then there is a method to get checksum. Then generate checksum. If you absorb in generate checksum it is asking for K and parameter right. So click on this SO key we can give the paytm details our merchant key. OK and parameters will give this input. Which will be type Map. So to throw exception throws it. Yeah. So this will give us the checksum. Suvans request will come from my form page then it will bind all those input to the redirect URL and it will process the payment one. But before payment it will find the checks. So once you pass the check sum then again you need to validate this checksum right? So if you observe here I didn't pass my mobile number and register email ID. So what I can do I can specify it in our properties file. So let me specify the port. 9090 and I want to specify the mobile number ATM dot mobile. Then I want to specify email, ID, OK. So I will add those my details in properties file. So as it is confidential I don't want to share here so let me pause this video for couple of seconds. So I added in properties fine. Now we need to get it from properties file so for that I can inject the environment here. So if you observe I am using environment provided by spring trimmer to get feel from the properties file. To use here. So here I need to get the mobile number so which I can get from environment dot get properties of key. Key is my paytm .mobile. Similarly I need to pass for email ID. So let me add it here. The key in my properties is paytm email and paytm mobile. So with these two input I can get my mobile number and email ID and rest other field will get as part of request right? So we created a rest endpoint we will redirect to the pay ATM server. Now once my payment success I want to display those message to my HTML page. So for that I need to write one rest endpoint. And then I need to validate the checksum. So I have the template, let me add it. So let me zoom this controller, yeah? So if you observe here I added one more private method to validate our checksum and then I added one great response redirect method with this URL page response. So if you go to application to iml that's what I mentioned here right? Once my payment is succeed then I want to redirect to this URL. This is what the URL I mentioned in my controller. So let me input this. I am checking if map contains the checksum or not then if you observe here. I'm doing the check some validation here. If I'm getting response code OH-1 then payment is success and if not payment failed and after payment what are the response I am getting. I capture in a result variable OK and I map to my UI so that is at the report dot HTML one more HTML you need to create here so. Let me add that HTML go to the template, so let me copy the name. So create one more HTML file here. So click Next finish. So in report that HTML I need to add the template design right. So I have the template let me add it. So let me add in HTML yeah so this is what the general spring MVC with time leaf. Already you had uploaded video on springboard time leaf. So if anyone not aware in it you can check my previous tutorial OK. So if you observe in controller I am returning one map right parameters which is the map and same map I am iterating here. K and Delhi. So it will give me all the information like what is your order, ID transaction, ID amount, all those information. OK so let me remove this. Yeah, so it's good. So I will add this source code link in gate up so that you guys can reuse this SO. Now we are good we can run our application. So let me verify anything we missed here. So let's run our application now. Run a Java application. Yeah so if you observe your application up on port 9090, so go to the browser. So let me open one new tab. Shaheer, let's type local host 9090. Now this is my HTML page which is the home page. So here I need to add the. Authorities who let me add something like this digit then customer ID this industry type, retail channel, web and amount I want to pay ₹2. OK so click on this. Pay with Paytm. So if you observe here it is redirecting me to the pay temp page with this transaction ID. So here I need to pass my bank details. So if you have your bank details you can share here. So let me add my bank details here. Now click on Pay Now. So this is what the demo one. This is just demo bank page. You can choose whether to make this payment successful or not. So I want to click on successful. Yeah so once payment is successful this is what the response I mapped in my report dot HTML. So my bank name is ICICI and currency gateway name HDFC. This is what my merchant key and order ID. All those information mapped here right? So I can show you the payment whether it is success or not. So let me go to my mail ID. Let me refresh this. So if you observe here this is what my payment status. Payment received with ₹2 and this is your my debit card details and my name and this is what the order ID right. So yeah this is how we can integrate your spring boot application to any payment gateway. So here I just demonstrate you how we can do with pay team so we can give a try with your bank details. So I will hide my bank details and all in confidential info here yeah. That's all about this particular video guys. Thanks for watching this video. Meet you soon with a new concern.

💳 Spring Boot Payment Integration With Paytm

A Live Example — by Java Techie

📌 Overview

In this tutorial, we will integrate Paytm payment gateway with a Spring Boot application.
You will learn:

How to obtain Paytm Merchant credentials

How to configure Spring Boot with Paytm

How to pass transaction data to Paytm

How to validate payment response

How to display transaction results to the user

🛠️ Project Setup
1️⃣ Create Spring Boot Project

Dependencies to include:

Spring Web

DevTools

Lombok

Thymeleaf

Project Structure Example

spring-boot-paytm/
 ├── src/main/java/
 │   └── com.spring.paytm.api/
 │         ├── PaymentController.java
 │         ├── PaytmDetails.java
 │         └── SpringBootPaytmApplication.java
 ├── src/main/resources/
 │   ├── templates/
 │   │     ├── home.html
 │   │     └── report.html
 │   ├── static/
 │   │     └── style.css
 │   └── application.yml
 ├── pom.xml

🔑 Paytm Credentials

Create an account at the Paytm merchant portal:

👉 https://developer.paytm.com

Collect:

Credential	Description
MID	Merchant ID
KEY	Merchant Key (Secret)
CHANNEL ID	e.g. WEB
WEBSITE	e.g. DEFAULT
INDUSTRY TYPE	Retail
⚙️ Add Configuration: application.yml
paytm:
  details:
    mid: YOUR_MERCHANT_ID
    key: YOUR_MERCHANT_KEY
    channelId: WEB
    website: WEBSTAGING
    industryTypeId: Retail
    paytmUrl: https://securegw-stage.paytm.in/order/process
    callbackUrl: http://localhost:9090/paytm/response

server:
  port: 9090

paytm:
  mobile: YOUR_PHONE
  email: YOUR_EMAIL

🧱 Model Class: PaytmDetails.java
@Component
@ConfigurationProperties("paytm.details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaytmDetails {
    private String mid;
    private String key;
    private String channelId;
    private String website;
    private String industryTypeId;
    private String paytmUrl;
    private String callbackUrl;
}

🌐 Controller: PaymentController.java
@Controller
public class PaymentController {

    @Autowired
    private PaytmDetails paytmDetails;

    @Autowired
    private Environment env;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/redirect")
    public ModelAndView initiatePayment(
            @RequestParam("orderId") String orderId,
            @RequestParam("customerId") String customerId,
            @RequestParam("txnAmount") String txnAmount) throws Exception {

        ModelAndView model = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
        TreeMap<String, String> parameters = new TreeMap<>();

        parameters.put("MID", paytmDetails.getMid());
        parameters.put("ORDER_ID", orderId);
        parameters.put("CUST_ID", customerId);
        parameters.put("TXN_AMOUNT", txnAmount);
        parameters.put("CHANNEL_ID", paytmDetails.getChannelId());
        parameters.put("WEBSITE", paytmDetails.getWebsite());
        parameters.put("CALLBACK_URL", paytmDetails.getCallbackUrl());
        parameters.put("EMAIL", env.getProperty("paytm.email"));
        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
        parameters.put("INDUSTRY_TYPE_ID", paytmDetails.getIndustryTypeId());

        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                .genrateCheckSum(paytmDetails.getKey(), parameters);

        parameters.put("CHECKSUMHASH", checksum);
        model.addAllObjects(parameters);

        return model;
    }

    @PostMapping("/paytm/response")
    public ModelAndView paytmResponse(HttpServletRequest request) throws Exception {
        ModelAndView model = new ModelAndView("report");

        TreeMap<String, String> map = new TreeMap<>();
        request.getParameterMap().forEach((key, value) -> map.put(key, value[0]));

        boolean isValidChecksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                .verifycheckSum(paytmDetails.getKey(), map, map.get("CHECKSUMHASH"));

        model.addObject("result", map);
        model.addObject("message", isValidChecksum ? "Payment Success" : "Payment Failed");

        return model;
    }
}

📄 Thymeleaf Views
home.html
<form action="/redirect" method="post">
    <input type="text" name="orderId" placeholder="Order ID" required />
    <input type="text" name="customerId" placeholder="Customer ID" required />
    <input type="text" name="txnAmount" placeholder="Amount" required />
    <button type="submit">Pay with Paytm</button>
</form>

report.html
<h2>Payment Status: <span th:text="${message}"></span></h2>
<table>
    <tr th:each="entry : ${result}">
        <td th:text="${entry.key}"></td>
        <td th:text="${entry.value}"></td>
    </tr>
</table>

📦 Add Dependency in pom.xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Paytm Checksum JAR (add via External JAR if needed) -->

▶️ Run & Test

Start application:

mvn spring-boot:run


Visit:

http://localhost:9090/


Submit form → redirect to Paytm → complete payment → return to report page.

🎉 Result

You will see a transaction result page like:

Payment Success
Order ID: 101
Amount: ₹500
Gateway: HDFC
Status: TXN_SUCCESS


You will also receive Email/SMS confirmation from Paytm.

🏁 Conclusion

You learned how to:

✔ Configure Paytm with Spring Boot
✔ Build request + redirect with checksum
✔ Verify response checksum
✔ Handle front-end payment screens

📌 Next Steps (Recommended)

Want me to also give you:

Razorpay Integration?

Stripe Integration?

PayPal Integration?

Just say "Next payment gateway" 😊

If you'd like, I can package this into a downloadable GitHub-ready project.