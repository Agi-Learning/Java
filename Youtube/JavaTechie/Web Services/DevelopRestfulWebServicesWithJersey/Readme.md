# Develop Restful Web Services With Jersey

* This tutorial will discuss how to develop Restful web services using Jacks RS, API with Jersey implementation. So already we know there is lot of approaches to develop Restful web services. So basically in my all previous example we used Spring rest integration. So let us give a try with this jersey implementation it will be more easy as compared to Spring rest OK. So let us get started guys. Let me open my Eclipse. So let's create a Springboard project. Click on next. So let's add the required dependency. We are going to add Jersey. So if you observe Jersey implementation start dependencies provided by Springboot itself so add it. And here we are going to use the database so let's. Start Doji peer repository, Spring data JPA and we are going to use in memory database. So let me add H2 in memory database. Analysts are the dev tools OK. And let's add the lumber to avoid Gator setup. So click on finish. Let's. Would to input this application. So application imported successfully. And there is some error. This error is due to the spring starter version. So here we use 2 dot 1 .5 which is the latest one S. Let's change it to 2.1 .4. I believe there is some bug on 2.1 .5. Yeah so there is no error. So just do one update. Yeah, so there is no error as of now. Let's create a required package first. So let me create a package called model. So let's create a package called. Which will be my database layer. Let me rename it. Let's create one more package called resource. So this resource is alternate to controller in spring MVC approach. So if you are using jersey implementation or rest is implementation better to name data as resource. So this is what the naming comments on people are following it. So let us create one more package, something called config OK. So let's create a model. First let me create a model called Employee. So let's add few field here, something like ID. Then name. Insert department. OK so as you added lumbo dependency you wanted to write getter set and manually here you just need to annotate at the rate data that will be come from lambo. OK and we want all argument constructor, so let's add it. And we want no argument constructor. So to make this model as my persistent so we can add here entity. It's not mandatory to annotate at the rate table. If you will not specify at the rate table, by default it will take your model name OK. So to make it entity you need to add other entity annotation so. Now let's create our DOW layer. So create a interface, name it like Employee do. And let us extend it from. JPA Repository. Even you can extend it from crowd repository. So here you need to pass your model which is our employee. And in ID we need to pass the data type of your primary key that is integer. OK so we created model and we created our dow layer. Now I want to add few employee object to save when my application will be up. Some innate method concept even you can go for springboard provided command line runner so better to use in it method here. In net Debbie, let's create a method. OK so to work with annotation you need to annotate your at the rate postmaster. So if you are using XML you need to write innate method then you need to specify your method name OK. So here I want to execute this method before my main method execution start that is why. United air post constant OK so here I want to initialize my database. So let's inject the database here. Private employee database. Down so injective zinc to add. Let me zoom it. Oh, you just use download dot 7. You want to save list of Employee object, so I'm going to use Java 8 here stream of. They were employing. OK. So we have all arguments must be. Run employee so you can give ideas 890 then give the name twitter. Then Department so I'm giving dev OK. Similarly add one more employee object. Give the name. Sam and let's change the ID to. 680 and mention the department QA, department OK. Similarly there is add one more employee object give the ID123. Name something like John. Let's mention the department HR, department OK and we need to convert it to least so. Kohli then pass the collectors. The two list OK. The semi colon. Yeah so this inert DB method will call before my main method and it will save these three objects to database. So. Now let's specify our resource. So go to the resource package, create a class called Employee Resource. This resource is alternate to your control OK. So here you need to provide your REST API method. From this class you need to expose your rest API. Let's create it. Suvana Tate here at The Red Path. Observe this path annotation is coming from WS .Rs OK. So this path is alternate to your request mapping in spring rest approach. So specify something like. Employee resource. OK. So here let's write a method to set the Employee object. So public employee. Save employee. Pass the employee argument here. OK. So let's inject the database here. Means our double layer. Implude of. Inject using auto add. So here we just simply need to call return dot dot save of our entity. The entity which we are going to save is my Employee object. OK so this is what my restify but how I can expose it so for that we need to add couple of annotation. First of all you need to specify the method type. HDTP method type whether it is gate operation or post operation that we need to mention. So in just implementation the annotation itself self explanatory about the role of method. So simply you can add post and listen. So that this method will perform my post operation and here you need to annotate at the rate consumes. So consumes means what you are expecting as a request data type whether you are expecting JSON or XML. That's what you need to mention you. So I am expecting your application slash jason OK. Similar way what you are expecting to return. That is why the annotation is called. Not here to add a method level. OK so here also we can. Specifically application Jason this is what my media type I am expecting as a request and I am expecting this as my response format. That's why I provided consumes and produces OK and for this method I need to specify 1 URL same in Spring rest. We are using request mapping here you need to use at the rate path annotation OK. Word save. This is what my post method. Now let's write a method who will return me list of Employee object. To write it public list of employee. Get all employees. Simply return from database dot. Find all method. So this is what the predefined method come from string data GPU concept. OK so import the list. So here also we need to provide the annotation, we need to provide the URL and we need to provide the HTTP method type. So this will be my get method so I can simply write at the rate gate annotation restore you can copy paste. Only we need to change them. You are really here, so get all employees. OK. I let go. Maybe a thing. Zoomit so let's write one more method. We will return employee object based on name or department so that we can check with the single input parameter so. Public will return me the employee. Something like GATE. Employee by name. OK. So here simply we can return. Downtown. Find by name so this method is not there in my database so I need to create that method. So let me ask the argument first. So let me create this method in my repository which is my dow OK. So in spring data JP we already learn. Find by name based on name field I want to search the employee object so find by will be always prefix and based on which field you want to search that you need to pass you. I want to search with name find by name OK. So go to the resource again. Yeah so we added this method find my name, save it. This is my one single input parameter, so you need to add your path annotation. Hey Cortana comes from Jabbar **** dot RS OK. So let me show you that. Yeah this is where the path Karam. This is where the alternative of are the red path variable annotation in spring rest approach OK. So you need to pass the name. OK let me add the Janetism. This method will also get method. With get Is the threat get employee? Then this is my dynamic parameter so that's why. I added your slash name OK so similarly we are doing with other path variable in spring rest. So let's test with these three API even you can go for the PUT and delete operation. So for that also there is simple annotation you can use. For PUT you can use either PUT annotation or DELETE. You can use at the rate delete annotation. OK so this will be more easy based on annotation easier can easily identify. What is the role of that method? Isn't it? So I'm not going to write for PUT and DELETE. So let's test this 3 API. So we created database, we created our repository and we created our employee resource. Someone need to be scan this employee resource. Anyway we are not going to use your any spring MVC component. So there is no dispersal servlet right? So that is why we need to add some scanner who will scan my resource class. So that's why we can go to our config package. Let's create a config class. Something like rest config you can name it. And this will be extends from resource config. OK so if you absorb this resource config is coming from org glass please jersey server OK so here just are the default constructor. Deselect all lists at the second one where you need to register our Employee resource class. So there is a method called register and you need to pass the component class. So my resource class is Employee resources. So just Employee resources class and. We need to annotate these two at the rate compliment. Even you can annotate it with other rate configuration so. We are almost done, so let us run our application. Run a Java application. Let me zoom the console. OK no identifiers specified for entity. Yeah, so we didn't add other ID annotation. So there will be no primary key found by this JPA so annotate. At the rate it OK. So let's rerun our application. Yeah, so if you observe application is up and running put 8080. So let's go to our resource class so that we can verify each REST API. OK so first let's check the gate all employees so that we can verify whether these three record which we saved at the time of application of is present in my in memory database or not right so. Let's go here. Type HTTP. Local host. 8080 slash. There is a root URL called employee resource. Then get all right click on send. Yeah, so we are able to see these three record, right John? Sam and Peter. OK. So let's. Add one employee object which is our save API. Let save employee pay so that we can verify whether record is going to be saved in my database or not. Change it to. Save and change the method type as posed at the body here. To make it Jason. Let me copy one entry from this. This is what we are going to add right and play object. So change it to. Oh, something like 111. Then give the name to Basant. Are the department here something like Admin OK or Dev anything? You cannot so click on send. Yeah so this record is got save. So let's test it whether this record is saved or not. Again I am calling the gate All employees. Now we are able to see here the four records isn't it? This is what the new record you added 111 basant and admin right. So go back to our employee resource we have the last API which will be phase the employee based on name OK. So let me copy this URL. Go back to your oatmeal. Gate employee by name. I want to search by name vasant. Click on send. Yeah its giving me the result right? So let me give John. It is giving generate based on field you are able to face the record. Similarly you can perform put and delete methodology OK. So this is how will be more easy if you are working from work, working through jobs implementation or rest is implementation. Everything you need to play with annotation. OK yeah so that's it about this particular video guys. If anyone have any doubt or concern you can add a comment and those who not subscribed it, please go ahead and subscribe it. Don't forget to press the bell icon guys so that you won't miss any update from Java Tiki. And thanks for watching this video.Oh my God.


📌 Develop Restful Web Services With Jersey

This tutorial discusses how to develop Restful Web Services using JAX-RS API with the Jersey implementation.
Previously, we used Spring REST, now we will try Jersey, which is easier in some cases.

🚀 Project Setup in Eclipse

Open Eclipse → Create a Spring Boot Project

Add the following dependencies:

jersey

spring-boot-starter-data-jpa

h2 (In-memory database)

devtools

lombok

If using Spring Boot 2.1.5 causes errors, downgrade to 2.1.4.

📁 Project Structure
src/main/java
 └── com.example
      ├── model
      │    └── Employee.java
      ├── dao
      │    └── EmployeeDao.java
      ├── resource
      │    └── EmployeeResource.java
      └── config
           └── RestConfig.java

🧱 Create Model

Employee.java

package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private int id;
    private String name;
    private String department;
}

🗂️ DAO Layer

EmployeeDao.java

package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    Employee findByName(String name);
}

🛠️ Initialize Database
@PostConstruct
public void initDB() {
    dao.saveAll(Stream.of(
        new Employee(890, "Peter", "DEV"),
        new Employee(680, "Sam", "QA"),
        new Employee(123, "John", "HR")
    ).collect(Collectors.toList()));
}

🌐 Resource (Controller Alternative)

EmployeeResource.java

@Path("/employeeResource")
public class EmployeeResource {

    @Autowired
    private EmployeeDao dao;

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Employee saveEmployee(Employee employee) {
        return dao.save(employee);
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    @GET
    @Path("/get/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByName(@PathParam("name") String name) {
        return dao.findByName(name);
    }
}

⚙️ Register Jersey Configuration

RestConfig.java

@Component
public class RestConfig extends ResourceConfig {
    public RestConfig() {
        register(EmployeeResource.class);
    }
}

▶️ Run & Test Endpoints

Application starts on:

http://localhost:8080

✔️ Endpoints
Method	Endpoint	Description
GET	/employeeResource/getAll	Fetch all employees
POST	/employeeResource/save	Add new employee
GET	/employeeResource/get/{name}	Fetch by name
🧪 Example Request (POST)
POST /employeeResource/save
Content-Type: application/json

{
  "id": 111,
  "name": "Vasant",
  "department": "Admin"
}

⭐ Output Example
[
  { "id": 890, "name": "Peter", "department": "DEV" },
  { "id": 680, "name": "Sam", "department": "QA" },
  { "id": 123, "name": "John", "department": "HR" },
  { "id": 111, "name": "Vasant", "department": "Admin" }
]

👍 Conclusion

Jersey is simpler due to annotation-driven configuration.

REST methods directly map to HTTP, like:

@GET

@POST

@PUT

@DELETE