# Spring Auto Rest Docs | Automate API Documentation

* Welcome to Java tech. In this tutorial we will discuss how to use Spring auto rest docs to auto generate rest API documentation. So in our previous example we understand how to generate API documentation using Spring rest docs with test driven approach. So basically we wrote test case using mock MVC and from test case we generate rest documentation. Isn't it? So if you observe in test case we wrote lot of additional stock to document our rest API so. We have to. Order test gate orders. So in each method we are adding logic to document our API right? We specify the identifier and we specify the pretty different format. Same for test gate orders method. So. This is not the exact API documentation logic. Sometimes we need to add path parameter, query parameter or request format description like that. Let's say I have 100 test case. Then in 100 test method I need to write this logic to document my rest API which you can say bottom for a developer isn't it? Then how we can automate this process. So to overcome these issues strengthwood developer came up with Spring autorest docs concept. Using that we can easily generate rest documentation. So if you are using Spring autorest docs concept then you no need to write this logic in each and every test method. OK. So let's go ahead and modify our existing code to auto generate documents. So here I'll take reference of spring official documentation. So we need to add spring auto rest docs dependency and we need to add one more marvin plugin. So if you'll calm down this is what the dependency. So let me copy this in our code. Let's go to palm XML. Then I can add this dependency here. Now then, let's copy the plugin. So let me add it in our code. To plug in we want go to your palm .Xml then if you. Come to the build section. You can add the plugin here yeah so let me save this. So we added here all the dependency and plugin. Now I can close all here so go to the test case. You don't want to write these in each and every test method so just remove it. And we need to close this so let's do it for our test gate orders method so we don't run this undo document so just remove it. Add the semi colon here and even you don't want this undo print so remove it. OK. Now if you observe in our taste case we don't write single line to generate documents right. So now let's go to our vufories method. Here we want to write the format and here we need to specify the snippets we want to generate. So go to this official document and then if you will calm down. You need to add this piece of code. Let me add it so that I can explain you so. Copy this go to your code. Then just remove this Bay and add it here. So first let's input the statement. Still, there is some compilation error, yeah. It is unable to find the object map. So what we can do we'll add a object of object mapper here will inject it. Then injective using autoid. Yeah so there is no compilation error. So let me close this. So if you calm down here we are just doing always do jackson result handler prepare Jackson with the help of object mapper whatever the request and response you are converting to Jason using this object maker and here we specify the identify the folder structure where we want to generate the snippet. So we just want to. Create the folder with name of method OK. Then we specify here request and response format which we mentioned pretty pray so that we can see our JSON as key value pair and we set limit JSN array length and we replace binary content in apply we are just configuring our rest documentation which we passed as part of method argument. Then we specify the uri, host, port and here we specify the snippets OK snippets. In the sense the adoc file which will be generated and we are informing or we are telling to spring good. These are the Adobe file I want to generate in my. Output directory. So basically once your application will execute it will generate HTTP, request, order, response and if you have any request field, response field path parameter, request parameter description. With all these prefix it will generate the Adobe file and in this particular section this one auto documents dot section you will find all the request, response description whatever the input and output. OK. So now let's run our test case to verify whether these snippets are getting generated or not. So let's go up. Let's run this test case. So your snippet will generate in this folder. This is what we mentioned in our previous example, right? So let it complete. So the execution started here. Yeah, so you can see. Let me maximize this. Yeah, all these two test cases now go to the project structure, go to the target folder. If you calm down, it created a folder called Generated snippets. It created two more folder test add order, test gate orders right and these two folder which you can see here tip. Test add order and test gate order is generated in our privatization. So what I will do here let me do one maven clean so that we can see the scratch folder of scratch snippets which is generated in this example OK. So let me clean it. Yeah, build success. Now let me rerun the test case. Yeah, if succeed now go to the target folder. Go to the generator snippets you can find only two folder right test order, test gate orders. This is what we mentioned in identifier section right method name. As you added hyphen so in my each word it is adding hyphen here OK so let's go inside this test add order. So if you observe you can see here auto description add up auto method path order. So these are the things we mention as part of snippet. Response request field. So if you come here you will find the request and request field path, parameter, method path, OK. So these are the adduct file. Same for test, let me place this. Yeah same for test gate orders. Whatever the snippets we mentioned we will find here. So let's open in your point. This is what the call request gate orders right? It looks good. Whatever the snippet we mentioned in our test case, we can able to see all the snippets in our target folder. Right now we need to convert this Adobe file as a HTML so that a person can easily read our API documentation. So in our previous example we understand how we can convert our adopt to HTML file. So that's the reason we created one folder called escript docs and inside these ascript docs we created one index dot file and inside that we are just specifying or we are just pointing to our snippet. So previously it created a folder called test add order in our previous example and this is what our HTTP request so. We generate this API documentation. You can see only request and response. Red now we just want to specify all the input whatever the path, parameter, query parameter, description or data type of my input, everything I want to specify. So what we want to do? This folder is not present in our target. So let's specify this folder and let's give the Adobe file here so. I just want to remove this. So even I don't want to specify any request and response here because if you observe. This is let's come down yeah, auto section dot headoffilethisautosection.adoptfile contains all the include so I can directly point to this auto section add up file from my index dot add up. So let's go here. So let me remove this. Here you need to give the path of our snippet generated folder. So the folder is test add order so add it add order. Now we need to give the adopt file. So from this test if and R order I want to give this auto section Adobe file. As I already mentioned this auto hyphen section contains all these adopt link OK if you want you can add individually. But as of now I am going to add this auto hyphen section .adobe. So let me specify here. autohyphensection.adopt. So let me add the same and we will change the folder. So I don't run this response, let's remove it. Even I don't run this text remove it. So here instead of taste add order we can give taste get orders OK. So let me change it to test gate orders. Yeah so we gave the snippet edoc file here. Now once you will drawn maven a case or maven clean instant, it will just convert these Adobe file to HTML file, OK. So let's run this maven phase. Go to M type your maven package. Yeah, so let's wait it to complete. Yeah, so we can see the build is succession. Now let me close this. If you'll come to this target folder you will find one folder called generate docs OK see if you go inside these generate dogs and if you open this index.Html file. So better let me open it in browser. So you can choose this Google Chrome. Yeah, so if you observe this is what our taste Java Tiki getting started with Spring REST Dogs. This is what we mentioned in our index.adobe file, right? Yeah, getting started with Spring REST Dogs. Then this is what another string or this I can say. So go to the browser and this is the description and this. These are the save order my controller method name and this is what the method type and URL. And as this is my post request I don't have any path parameter and query parameter and if you observe here it mention the request free with input field as well as the data type and whether it is optional or required. So these table structure is generated by spring rest autotomes OK because in test case you did not specify manually for each. Test case we did not specify request field or response field. So if you observe this is what the request field and this is what the response field. Because in our save order method the input is least of order object and the return type is list of Order object. That's why the request and response structure is showing same here. And if you observe it is adding 1 array right? Because our argument the request and return type will be least if it is a object. You can directly find the attribute here OK. So if you will calm down this is what the example request for your post API. This is what the call request and this is what the example response. Similarly for second test case which will be our gate orders, the HTTP method type will be gate and the URL will be slash gate orders for that also we don't have any path parameter and query parameter but even you don't have any request fields because this is the gate API. Once we will hit the request it will fetch list of order object from database and routing return back to us OK. That's why it contains only response fields. So again the response field is least of order object. That is why you can see the array symbol here. And if you will, calm down. This is what your example request, so Etheric P local host 8080 then slash get orders. No additional parameter here, so if you calm down you can find the example response here. And this is what the text we added at end and this is some putter added by Spring rest dalks. Yeah this is how we can generate rest documentation using Spring rest Orthodox which will be in built API provided by spring boot and the contribution was given by another company which will be scalable capital. So you can check this documentation. I will add this link in video description so that you guys can follow this step. Yeah. That's all about this particular video, guys. Thanks for watching this video. Meet you soon with a new concern.

🚀 Spring Auto REST Docs — Automate API Documentation

Welcome to Java Techie!
In this tutorial, we will learn how to use Spring Auto REST Docs to automatically generate REST API documentation.

Previously, when using Spring REST Docs, we had to write documentation logic inside every test (using MockMvc). This becomes repetitive when you have many test cases, e.g., 100+ methods.

To avoid this, Spring Auto REST Docs allows us to automate documentation with minimal configuration.

📌 Why Spring Auto REST Docs?

With traditional REST Docs:

You write documentation logic in every test method

Manually specify request/response, fields, path/query parameters, etc.

Difficult to maintain for large projects

Auto REST Docs reduces this overhead by generating documentation automatically during test execution.

📦 Step 1 — Add Dependencies & Plugin

Add the following to your pom.xml:

<dependency>
    <groupId>capital.scalable</groupId>
    <artifactId>spring-auto-restdocs-core</artifactId>
    <version>2.0.11.RELEASE</version>
    <scope>test</scope>
</dependency>


Add Maven plugin:

<build>
    <plugins>
        <plugin>
            <groupId>capital.scalable</groupId>
            <artifactId>spring-auto-restdocs-maven-plugin</artifactId>
            <version>2.0.11.RELEASE</version>
            <executions>
                <execution>
                    <goals>
                        <goal>generate</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>

🧪 Step 2 — Clean Test Code

Instead of adding documentation handlers in every test, remove the manual doc steps:

❌ Old Code (to remove)

.andDo(document("test-add-order"))
.andDo(print());

⚙️ Step 3 — Configure Documentation Handler

Add the following in your test configuration:

@Autowired
private ObjectMapper objectMapper;

@BeforeEach
void setUp(WebApplicationContext context, RestDocumentationContextProvider provider) {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
        .apply(documentationConfiguration(provider))
        .alwaysDo(prepareJackson(objectMapper))
        .alwaysDo(autoDocumentation())
        .build();
}


This automatically:

Configures JSON formatting

Sets output directory

Generates snippets (request, response, fields, params)

📁 Generated Documentation Structure

After running tests:

target/
└── generated-snippets/
      ├── test-add-order/
      │     ├── http-request.adoc
      │     ├── http-response.adoc
      │     ├── request-fields.adoc
      │     ├── response-fields.adoc
      │     └── auto-section.adoc
      └── test-get-orders/
            └── ...


The most useful file is:

auto-section.adoc


→ It includes all snippet references automatically.

🧰 Step 4 — Convert AsciiDoc to HTML

Create an index file:

src/docs/asciidoc/index.adoc

= Getting Started with Spring REST Docs

== Save Order API
include::{snippets}/test-add-order/auto-section.adoc[]

== Get Orders API
include::{snippets}/test-get-orders/auto-section.adoc[]

✔️ Build Docs

Run Maven:

mvn clean package


This generates:

target/generated-docs/index.html


📌 Open it in a browser — and you will see:

Method summary

URL

Request / Response fields

Fields table (type, description, optional?)

Example request/response bodies

Example:

POST /addOrder
Request Fields
| Field | Type   | Required |
|-------|--------|-----------|
| id    | Long   | Yes       |
| name  | String | Yes       |

🎉 Final Result

With Spring Auto REST Docs:

No more repetitive test documentation code

Documentation updates automatically when APIs change

Consistent structure across the project

Cleaner and maintainable

📚 Additional References

Spring Auto REST Docs: Scalable Capital

Spring REST Docs: Spring Boot Official Docs

🙌 Conclusion

Using Spring Auto REST Docs drastically simplifies API documentation.
It brings the power of Spring REST Docs — but without boilerplate in every test.

If you'd like, I can also:

✅ Create folder structure diagrams
✅ Export this as PDF
✅ Generate sample project scaffold

Would you like a ready-to-use template project? 🚀