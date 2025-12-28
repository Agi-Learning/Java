# Enable Cross-Origin Resource Sharing in REST

* So in this tutorial we are going to discuss about how to enable Cross Origin Resource Sharing for your REST API. So basically this concept used for security purpose where you can have fully control on your application like you can add restrictions who can access your API and who can't access it. So let us understand how we can add restriction and on what basis we can apply restrictions for our API. So let's go through an example guys so that it will easy for you to understand what exactly this Cross Origin resource sharing. So you can see here I have one application called my portal which is hosted on port 8080 and it can be accessed by multiple client with different URL. So in my portal application I can add the restrictions where client can access my application and even I can add the restrictions on URL means I can specify with which URL client can access my application. But adding the restrictions on URL depends on three factor. Which is protocol, POST and port. So the protocol can be HTTP or HTTPS. The host can be anything and the port can be any number. To specify in my portal application which URL it will allow OK, it means suppose assume I specify in my portal application, it will only allow HTTP LOCAL host 99 request. So if any other request is coming with different URL it will deny that request. So that's what the Cross origin resource sharing concept. This is very simple concept where we are just specifying the URL with which client can access our application OK. So let's quickly create a myputal application and expose on REST API. Then create a client and let's try to access it so that we can get to know about the behavior of Cross Origin Resource Sharing. So let's get started guys. Let's go to the Eclipse. So let's quickly create a Springboard project. Click on New Spring Starter Project. I So let's name it to. My portal so. Click on next. We are going to add only web dependency. So we are using spring boot version 2.1 .5 which is the latest one. Click on next. Click on finish. So let's create the My Portal client as well. Click on File New Screen Starter Project. Name it two. Hello. Hey, Cortana. Hey, Cortana. OK. My hotel client. Are the required dependency I am adding where. And here we are going to add the thyme leaves from my portal client. We're going to consume the my portal right using Ajax code. So that's why we need the thyme leaf component. Click on. Don't finish so here we are using 2.1 5. There is some issue on the springboard starter palm parent parent. So let's change it to the 2.1 .4. If you observe, we are getting the error in our XML root tag right? So let us change it to 2 dot. 1.4. Similarly, let's do it for our client. So now we need to update both to my win project. The source update for it click on OK. Yeah, so if you observe there is no error now. So let's close this two. Go to my portal application. We are going to expose and raise 10 point from this application. So let's write a REST endpoint something like public string. I. Greeting. Best returns on the mystery here I'm returning something like Welcome to Java Techie portal. OK so we need.Yeah, so I'm using gate mapping. If the URL something like access, similarly we need to annotate this class with at the rate rest controller annotation. OK. So we are exposing one REST endpoint with some dummy string message. So now let's write our client. Go to the my Portal client. Move to the main class. So here we are going to annotate. Add the rate controller because from this my portal client we are going to access through them HTML, Azure right? So that's why we need to return on view. So let's return something like home. Return the HTML page name so I'm mentioning home. So we need to annotate this one with URL mapping. So use get mapping here. So get the slash. Let's create a HTML page. With the name home. Go to the template folder, click on this other. Search HTML. So name it. So from this HTML, we need to add the few content here. But first let. Let's create our Javascript Azure OK click on other type JavaScript. So create a JavaScript source file. Something like Potal OK. Click on Finish. So here actually we need to write our Ajax curve so let me add that content. So if you observe this is whatever exact Azure. We are we are invoking our my portal service with the HTTP local host and the port and the URL which we mapped in our my portal right? This is what we mapped. So and this is what the request ID and this is what the response ID. So let's add the content in our HTML phase. So basically we are going to add 11 button here by clicking on that button we should get the response by invoking this. Hotel note JS Ajax school to our mypotel service OK so let's go to the home dot HTML and let's add the content here. So if you observe here I am loading my portal.Js so. Here we need to specify the ID that's are the same ID which is specified in our objects. Similarly, specify the ID for the response message. ASo we are almost done. We wrote our mypotel application where we expose on REST EPA and we wrote client for it. So. We need to change the port of our my portal client because my portal will run on port 8080. So let's change the server port here server dot port, change it to 9090. Same each case we discussed, right? Estrada, 9090. Yeah, so let's run our application. Run a Java application. Yeah, it's upon port 8080. So now let's run our client. Pravna's Java application. It's drawn on port 9090. Yeah, it's running on 9090 now let's test our API from our browser. Go to the Chrome. 9090 Yeah we are getting access my portal tab. So let me inspect this so that we can see the. Error. So if you click on this access, my portal will get the error response right. So let me copy this that I can show you properly. Put our code. So if you observe here HTTP local host 808 axis which is our my portal URL. From origin Detritippi Lucalus 9090 which is our client husband dropped by CORS policy Cos policy in rigid. Nothing Cross Origin resource sharing policy No access control allow origin header is present on the requested resource. So from this resource local host 9090 it is not allowing to access our my portal application. This is what the default behavior of our browser right as we are doing the Ajax call so to enable this cross origin policy to. Give access in our my portal applications so we can write a annotation something called. Cross origin and we need to provide the origin of it. So from which origin our client is trying to access HTTP local host 9092 specify here. So it looks straightforward approach in Spring Boot, right? Only one annotation is enough to handle the cross origin policy. So yeah, so now let's test our application. So we need to rerun our My Portal application as we did the changes here, right? So let me stop it first. Yeah, so let's rerun it. Yeah, it's upon 40, 8080, right. So let's go to the browser, refresh it. Now if you click on access my portal we are able to get the result right. Welcome to Java Tiki putta. So if you observe here in code. We added this cross origin policy in our method level. What if we have multiple controller method right? So it's not recommended to write in metal level. We can keep it global in class level so that whatever the method present in my controller it will be handled by this mobile annotation. So. Here we are enable for origin HTTP local host 909. So if you want to disable it you can simply add the star Mark here. Now it will allow all the origin because we disabled the cross origin OK. So let's test it. Let me stop my photo application. Let's rerun it. Yeah, so it's open for 8080, right? So let's go to the browser, refresh it. Now click on access my footer you are able to see the result. Right now it disable the cross origin policy in our application itself. Now whatever the origin will try to access our my portal application they can able to get the result. OK so if my application contains more than 1 controller or you want to make this cross origin policy globally you want to maintain it. Then instead of writing in each class label or method level we can make it global by using a bin called web basic configure adductor. So let me write that. MVC configure, so let us write the method. So basically this Webmbc configure is one interface. We are going to provide the. Implementation of it. So return it. With MBC configure. So here you need to override one method or something like little. Yeah, hard cross mapping. So we can type your registry dot add nothing if the pattern I want for all the requests that's next last star and. Allow origin. We want to specify origin. If you want to disable you can add star. If you want to add for specific origin that origin you need to provide here. OK. And we need to annotate this with at the rate bean. So we have option we can add in method level or if you want to global make it global for a controller class. If you have multiple method better to write it in class label. If you have multiple controller class then you can make it go global across your application right? So that's why we created this beam. So let me comment this. So let us test it. So let us rerun our application first. Let me stop it. My portal application. Now let's run it. Yeah, it's up now. Now go to the browser. Click on Access my portal. Yeah we are able to get the result right without any failure. So yeah this is how we can configure the cross origin in your application whenever you want to avoid the external attack to your application. Basically it is used whenever your product or application will be B to BB to B means business to business. Suppose I developed one product and I want to deliver that product to specific client. In such case we should provide this cross origin yeah so that's it about this particular video guys. If anyone have any doubt or concern you can add a comment and those who not subscribe date, please go ahead and subscribe it. Don't forget to press the bell icon guys so that you won't miss any update from Java Tiki. And thanks for watching this video.


📄 enable-cors-in-rest.md
# Enable Cross-Origin Resource Sharing in REST

In this tutorial, we are going to discuss how to enable **Cross Origin Resource Sharing (CORS)** for your REST API.

CORS is mainly used for **security purposes** where you can control:
- Who can access your API
- From which URL / domain they are allowed
- Which requests should be blocked

---

## 📌 Why CORS?

You can restrict access to your application based on:
- **Protocol** → `http` or `https`
- **Host** → domain or localhost
- **Port** → 8080, 9090, etc.

### 📌 Example:
> MyPortal Application → Runs on `http://localhost:8080`
> Clients trying to access from different ports



Client-1: http://localhost:9090

Client-2: http://localhost:9091


If CORS is disabled, only same-origin requests are allowed and others will be blocked.

---

### 📺 Illustration References:
> *(from your screenshots)*

- MyPortal running on **8080**
- Clients accessing from **9090 / 9091**
- URL components:
  - `http` → Protocol
  - `localhost` → Host
  - `9090` → Port

---

## 🛠 Step 1 — Create Spring Boot Apps

### **Backend: MyPortal**
- Spring Web
- Expose REST endpoint
- Runs on **8080**

```java
@RestController
public class MyController {

    @GetMapping("/access")
    public String greeting() {
        return "Welcome to Java Techie portal";
    }
}

🛠 Step 2 — Create Client App
Frontend: MyPortal Client

Thymeleaf + AJAX

Runs on 9090

home.html

<html>
<body>
<button id="btn">Access MyPortal</button>
<h2 id="response"></h2>
<script src="portal.js"></script>
</body>
</html>


portal.js

document.getElementById("btn").addEventListener("click", function(){
    fetch("http://localhost:8080/access")
        .then(res => res.text())
        .then(data => document.getElementById("response").innerHTML = data)
        .catch(err => console.log(err));
});

🚫 Error without CORS

When clicking the button:

Access to fetch at 'http://localhost:8080/access'
from origin 'http://localhost:9090'
has been blocked by CORS policy


Default browser security blocks cross-origin requests.

✅ Step 3 — Enable CORS
Option 1 — Method Level
@CrossOrigin(origins = "http://localhost:9090")
@GetMapping("/access")
public String greeting() {
    return "Welcome to Java Techie portal";
}

Option 2 — Class Level
@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class MyController { ... }

Allow All Origins
@CrossOrigin(origins = "*")

🌍 Step 4 — Global CORS Configuration

Use when multiple controllers exist.

@Bean
public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("*"); // OR "http://localhost:9090"
        }
    };
}


Now any origin can access the application.

🎯 When to Use CORS?

CORS is recommended for:

SaaS products shared between businesses (B2B)

APIs consumed by external clients

Preventing unauthorized access & attacks

📌 Summary
Target	Add Where?
Single Method	@CrossOrigin on Method
Entire Controller	@CrossOrigin on Class
Entire Application	WebMvcConfigurer Config Bean
🎉 Final Output Success

Request now works and prints:

Welcome to Java Techie portal

🙏 Outro (from your text)

If anyone has any doubt or concern you can add a comment.
Those who not subscribed yet, please subscribe and press the bell icon.
Thanks for watching this video.

Done 🎉

Your .md file is ready to save.

If you want, I can generate a downloadable file too.
Would you like:
✔️ .md file download
✔️ .pdf version
✔️ .docx version

Just say which one you want. 😊