# SpringBoot : Spring Cloud Task

* In this tutorial we will discuss about Spring Cloud task. So Spring Cloud task makes it easy to create a Saltlet microservices and if you are using Spring Cloud task then we can track execution history of any task which is running in production environment. So let's understand how to use Spring Cloud Task with an example. Even I'm going to explain the internal architecture of Spring Cloud Task, how it internally works, OK. If you want to know more about Spring Cloud Task, you can check out these Springboot official documentation. Let's get started. Let's create a Springboard microservice application. New Spring starter project. So click next. Let me add the depend. Welcome. Nancy call task. If you observe here it came from Spring cloud so click finish. Yeah, so application imported. Just go to the palm.Xml. Let's change the springboard version to 2.104. Let me save it. Then let. Let me do one maaghan update. Yeah, so we're good. There is no error, just go to the main class. As we are using Spring cloud task, we need to enable the task first. So here I want to run my piece of code once my application will start right? So that's why I'm using here command line runner so we can implement. Common land runner is an interface and it contains one run method. So this run method it is kind of callback method. We are not going to call this method. So once your application will start up this method will automatically. OK. So here what I want to do. Let me write something sis out. Welcome to. Then I just want to pass a runtime argument. OK. So let's assume this is what my task and for this task I want to track the execution. So let me run this application. But before Ron I need to set the runtime argument right so right click then go to the wrong ads. Then choose your ROM configuration. Go to argument. Let me pass something like Java Tiki. Yeah, then click apply. Click on run. Before that let me save the main class. Yeah, so if you. Go to the console. We can get the result here, right? Welcome to Java Tiki. This is what we mentioned, right? Welcome to this is what my prefix and I appealed with the runtime argument. Right, so if you go to the console once again, we only receive the. SOPLN statement which we wrote in our system .out.print. Apart from that we don't have any log idea regarding our task history right? So what we can do to enable that? We just need to go to our application dot properties file. And we need to set the logging level. So this is what the logging label. And I point to Spring Trimmer cloud task. So now if I run my application. Let me run it. Go to the console. Here is our statement apart from that you can find here it create a task execution with execution ID then it contains couple of field like parent execution ID exist code and task name you can find here. It is considering as application and. We have the start time, it will tell when your application started, then we have end time exist message, then external execution, ID error message and the argument which we passed. OK now after that it will execute our task and we got the response here then it will update the task execution. So you can find here it is updating the task execution again it contains all the execution code. Time exit message if there is an error. You can find the error message here. Right so here you can find the task name is application. If you want to customize it just go to your properties file just write spring. Dot application name, yeah. Let me specify something like Java Tiki task. Now if I run my application. I should able to see the task name as Java ticket task. Yeah, it's reflecting here, right. And it update first it create the execution task then after that it will call our task then again it will update the execution task. Right now it's time to understand how it internally work, how this spring cloud enable this task execution with those fields. So let's go to our main class. So if you observe here we added this annotation at the rate enable task. So this annotation tells spring cloud task to boost rough its functionality and by default it imports an additional configuration class which is something like spring task configuration. Or something like let me search it control safety. Simple task, yeah, this is what the task simple task auto configuration. So if you will go to this class you can find something. It will internally create one task repository. So task repository is on interface and it contains the implementation like simple task repository. So if you go and set this simple task repository you can find your couple of method. So let me zoom. So we can find the method complete task execution and create task execution. So basically we are just using these two method complete task and create task. This will create this method will in book once our application will start. So it will take the argument as task execution and it will update those value to the database then it will print the log statement. Which is creating with all the task execution input. So if you'll go to this task execution you can find all the field which is just seen in our concept. Right, so similarly there is an Another method which is complete task execution. Again it will take couple of argument and it will do some business again it will update to the database then it will train the log statement. Which will be updating. So first create task execution method will inbox then our original task will execute. Once this task is completed without any failure then this complete task execution and update. So I will show you how we can integrate this with database like how we can store those task history to the database OK. So once again let me show you in console. Let me join the console. So here you can see the lock start from creating. This will call the create task execution and here you can see the log start from setting, it will call complete task execution right. So let me go to the main class. So here if you want to customize your log statement or you just want to trace something like before method call or after method call there is something called Task execution listener which we can use. So let me show you the use of task execution listener we can just implement. Sorry its already implemented so just task execution listener and we just need to override 3 method. So if you take the method name it is self explanatory. This is what the on task startup and on task end on task field right? So once your task will start then this method is in book and if your task is completed this method if there is any failure this on task failed method will invoke OK. So let me show you what we can do. Let's add some statement. So task execution contains all the field which we seen in console. So you can customize your own message. So let me mention like task name. Taskexecution.get task name. And I just want to print task execution ID. So get it from task execution dot. Get execution. No, simply I just want to print here started. So let me copy this statement in all two method. So here I just want to change on task N so. Started I can mention your completed. And here I can specify something like task fail, right? So let me set this now if I will run my application. Let me join the console. We can find your right task name javatiki task then execution ID0 and it started and then it execute our task then on task completed. We got this response right Java ticket task execution ID and it's completed. There is no failure. So this on task failed method. Not in book, yeah. This is what we didn't get any response from this method because there is no error right? We just got the response from on task startup. And on task end. So this is how you can customize your task message or if you want to do some preprocess logic or your post process logic before your task in book you can mention here OK. So if you observe here we just use task execution listener and then we overwrite these three method. But if you do not want to use this interface and you want to play with annotation then just remove this interface and justice annotate here. Deepurta 's. On this you can annotate. After task. And in this failure task we can specify something like. Fail task right? Yeah, you can change the method name. Let me change it start. And then I can specify it fail. Let me set this. Let me run our application. Go to the console. You can find the same message right even though we didn't implement from task execution listener using annotation. Also we can customize our log message which will be for task execution. So before then it invoke our task then on complete of task. So this will helps us in production environment so that the developer can easily identify about the task execution history like how much time the task took to complete and what are the argument you pass. And if there is any error message you can find it, you can find it the exit code. What are the field is there in our task execution model. You can keep track all those variable or all those properties in your log file. Right here we just print in our console so it should be in lock or else we can set those data in our database. So I will show you now how we can. Save our task execution history in our database. First let me go to my Mysql database. Let me create a schema. Database, let's say Spring Cloud Task. You can specify any name here. Then I want to use this use. OK. So let's remove this. In club task you should not add das here. So let me run this. Movie created a schema and you just using it. So go to the application.properties file. We need to add here all the data source related properties so spring dot data source. Dot Driver class name, username, password everything we need to say to you. So let me add that I already copied those syntax. Let me paste it here. This is your the driver class URL, username and password so SQL. Then I wanna detail all those properties related to data source and my GPA. So we added all those properties but we need to add the dependency right? So we need to add spring JDBC starter and we need to add my SQL connector. So let me add those two dependencies. So let's go here and paste it. So springboot starter JDBC and MySQL connector so let me save.  Let's run our application now. So we just added that associated properties and Do you just update your schema name which we created in our Mysql database? Then we just adapt those two dependents. So now let me run our application. Java application. So yeah its up now. Now go to the database. Let me refresh this. You can find the schema here right spring cloud task. So if you go inside that it automatically create pipe table. The table is task execution, Task execution parameters, task low, task sequence and taskbar. So if you go to this task execution, click on select mode. You can find here the first task response task ID 1 then start time and end time. The task name you can find here Java ticket task right? This is what we mentioned in our application properties and. When it got last update all those things we can track in our database. So if you go to this task execution param. You can find the task parameter which you pass in our runtime argument, right? Java TQ is set. So what we can do just go to our application. Let's change some value here. Ronald's run configuration go to argument. So what we can specify something like Java Tiki? Youtube channel or else jabba Tiki community. OK now apply. Run it. Right, this is what the response. Welcome to Java Tiki community. If you go here you can find the. Argument got changed. Java Tiki community. Now if you'll go to the database. So let's check in this table. You can find it right, the task param is got changed Java Tiki community and the task execution ID is updated to 2. So similarly if you go to this task education, you can find the 2 task here. So this is what the 2nd task we received here after update the runtime argument from Java DK to Java tech community. Yeah, so this is how we can work with Spring Cloud Task. So we can store all our task execution history in our database. So when a developer need to get information about a specific task, he can filter it out based on the task execution ID from our database itself. You no need to go to the log file to verify it, right? Yeah, that's it about this particular video guys. Thanks for watching this video.

📌 Spring Boot: Spring Cloud Task Tutorial

In this tutorial, we will discuss Spring Cloud Task, how it helps in creating short-lived microservices, and how to track task execution history in a production environment. We will also explore internal architecture, database integration, and custom logging.

🚀 What is Spring Cloud Task?

Spring Cloud Task makes it easy to create short-lived microservices (tasks) that:

Run once and exit

Track their execution lifecycle

Store metadata such as execution time, status, exit code, and error info

🔎 More details: Check Spring Boot official documentation

🛠️ Creating a Spring Boot Microservice with Spring Cloud Task
1️⃣ Create a Spring Starter Project

Add dependency:

Spring Cloud Task


Update your pom.xml and (example) change Spring Boot version:

<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.0.RELEASE</version>
</parent>

🧠 Enable Task + Execute Code Once
@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTaskApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Welcome to " + args[0]);
    }
}


Run application with runtime argument:

JavaTikki

📊 Enable Task Execution Logs

Add to application.properties:

logging.level.org.springframework.cloud.task=DEBUG
spring.application.name=javatikki-task


Now logs will show:

Creating: TaskExecution{taskName='javatikki-task', ...}
Completed: TaskExecution{status='COMPLETED', ...}

⚙️ Internal Architecture (How It Works)

@EnableTask triggers:

SimpleTaskAutoConfiguration
 ↓
TaskRepository
 ↓
createTaskExecution()
run task
completeTaskExecution()

Key Components
Component	Responsibility
TaskRepository	Stores execution state
TaskExecution	Metadata container
TaskExecutionListener	Hooks for lifecycle events
🎯 Listening to Task Lifecycle Events
Using Listener Interface
@Component
public class MyTaskListener implements TaskExecutionListener {

    @Override
    public void onTaskStartup(TaskExecution task) {
        System.out.println(task.getTaskName() + " started");
    }

    @Override
    public void onTaskEnd(TaskExecution task) {
        System.out.println(task.getTaskName() + " completed");
    }

    @Override
    public void onTaskFailed(TaskExecution task, Throwable e) {
        System.out.println(task.getTaskName() + " failed");
    }
}

Using Annotations Instead
@Component
public class TaskListener {

    @BeforeTask
    public void start(TaskExecution task) {
        System.out.println(task.getTaskName() + " started");
    }

    @AfterTask
    public void end(TaskExecution task) {
        System.out.println(task.getTaskName() + " completed");
    }

    @FailedTask
    public void fail(TaskExecution task) {
        System.out.println(task.getTaskName() + " failed");
    }
}

🗄️ Save Task History to Database (MySQL)
1️⃣ Create database
CREATE DATABASE springcloudtask;
USE springcloudtask;

2️⃣ Add DB Configuration

application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/springcloudtask
spring.datasource.username=root
spring.datasource.password=YOURPASS
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Add Dependencies
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>

4️⃣ Run Application

📌 MySQL will auto-generate tables:

Table Name	Description
task_execution	Task run history
task_execution_params	Runtime arguments
task_lock	Task locking
task_seq	Sequence generator
task_execution_metadata	Meta tracking

Query example:

SELECT * FROM task_execution;

🔁 Running With Different Arguments

Change run configuration to:

JavaTikki Community


DB updates:

SELECT * FROM task_execution_params;


Shows:

| execution_id | task_param_value     |
|--------------|-----------------------|
|      2       | JavaTikki Community   |

🎉 Conclusion

Spring Cloud Task helps you:

✔ Run short-lived batch jobs
✔ Track execution lifecycle
✔ Store history in DB
✔ Debug failures fastAnd.
✔ Avoid parsing log files manually

❤️ Thanks!

This covers Spring Cloud Task basics, architecture, customization, and DB integration.

If you'd like, I can also provide:

✔ A GitHub-ready project structure
✔ A diagram/architecture image
✔ A YouTube-script style version

Would you like a downloadable .md file or zipped project template? 😊