package com.luv2code.mycodeapp;

/**
 * Hello world!
 * 
 * ## Maven Overview

### You will learn how to...

 * Create Maven projects with Eclipse
 * Add dependencies to Maven pom.xml file
 * Build and run Maven projects
 * Develop Maven projects for
 	* Java apps and Spring apps
 * Import Maven projects
 * Run Maven from the Command_Line

 ### Practical Results

 * Cover the most common Maven tasks that you will need on daily projects
 * Not an A to Z reference ... for that you can see Maven Reference Manual
 * But don't worry, I will give you links to
 	* Maven Reference Manual
 	* 3 Maven eBooks
 	* Maven Cheat Sheet

 ### Free Maven Resources

 * Maven Reference Manual
 	* www.luv2code.com/mavenreferencemanual

 * Maven eBooks
 	* www.luv2code.com/mavenbooks

 * Maven Cheat Sheet
 	* www.luv2code.com/mavencheatsheet

 ### What is Maven?

 * Maven is a Project Management tool
 * Most popular use of Maven is for build management and dependencies

 ### What Problems Does Maven Solve?

 * When building your Jave project, you may need additional JAR files
 	* For example: Spring, Hibernate, Commons Logging, JSON etc...
 * One approach is to download the JAR files from each project web site
 * Manually add the JAR files to your build path / classpath

 ### My Project without Maven

 Check Tab ->

 * My super cool app, i am gonna need these files, Spring,Hibernate,Commons Logging, JSON, soon. and then so need the developer actually go to each one of the web sites download it, to download Spring JAR files, Hibernate JAR files, Apache Commons JAR files, JSON JAR files and the manually add those to my build path. Now maven actully help us with this process and do lot these work for us.

 ### Maven Solution

 * Tell Maven the projects you are working with (dependencies)
 	* Spring, Hibernate etc...
 * Maven will got out and download the JAR files those projects for you 
 * And Maven will make those JAR files available during compile/run
 * Think of Maven as your friendly helper / personal shopper :- )

 ### My Project with Maven

 Check Tab ->

 * With the Maven Central Repository (remote) on the internet, and we have a super cool app we simply tell maven, hey here is our shopping list I give to maven and then maven will go off and download the spring JAR files and hibernate JAR files soon and pull it my computers and make it available for need to use 

 ### Maven - How It Works

 Check Tab ->

 * Using Maven Project config file that maven read that basically your shopping list so maven read your config file then may know check local repo resides on your computer if you don't have files in a local repo then maven watch go out to the internet maven set your repo which is remote and then pull those JAR files memeber maven central repo on the internet then save version those files in your local repository seeing on build on a cache and then maven use that build and run your application.

 ### Handling JAR Dependencies

 * When Maven retrieves a project dependency
 	* It will also download supporting dependencies
 	* For example: Spring depends on commons-logging ... 
 * Maven will handle this for us automagically

 ### Building and Running

 * When you build and run your app ...
 * Maven will handle class / build path for you
 * Based on config file, Maven will add JAR files accordingly

 ### Standard Directory Structure

 * Normally when you join a new project
 	* Each development team dreams up their own directory structure
 	* Not ideal for new comers and not standardized
 * Maven solves this problem by providing a standard directory structure

 src/main/java --> Your Java source code
 src/main/resource --> Properties / config files used by your app
 src/main/webapp --> JSP files and web config files other web assets (images, css, js, etc)
 src/test --> Unit testing code and properties
 target --> Destination directory for compiled code. Automatically created by Maven

 ### Standard Directory Structure Benefits

 * For new developers joining a project
 	* They can easily find code, properties files, unit tests, web files etc...
 * Most major IDEs have built-in support for Maven
 	* Eclipse, IntelliJ, NetBeans etc
 	* IDEs can easily read/import Maven projects
 * Maven projects are portable
 	* Developers can easily share projects between IDEs
 	* No need to fight about which IDE is the best LOL!

 ### Advantages of Maven

 * Dependency Management
 	* Maven will find JAR files for you
 	* No more missing JARs
 * Building and Running your Project
 	* No more build path / classpath issues
 * Standard directory structure

 ### My Personal Best Maven Benefit(s)

 * Once you learn Maven, you can join a new project and be productive
 * You can build and run a project with minimal local configuration

 ### Maven Key Concepts

 * POM File - pom.xml
 * Project Coordinates

 #### POM File - pom.xml

 * Project Object Model file: POM file
 * Configuration file for you
 	* Basically your 'shopping list' for Maven:-)
 * Located in the root of your Maven project

 ##### POM File Structure

 * Project meta data ( Basically information about your project, Project name, version etc Output file type: JAR, WAR, ...)
 * dependencies (List of projects we depend on Spring, Hibernate, etc...)
 * plugins ( Additional custom tasks to run: generate JUnit test reports etc...)

 ##### Simple POM File

 ```xml
 	<project ...>
 		<modelVersion>4.0.0</modelVersion>
 		<groupId>com.luv2code</groupId>
 		<artifactId>mycoolapp</artifactId>
 		<version>1.0.FINAL</version>
 		<packaging>jar</packaging>

 		<name>mycoolapp</name>
 		<dependencies>
 			<dependency>
 				<groupId>junit</groupId>
 				<artifactId>junit</artifactId>
 				<version>3.8.1</version>
 				<scope>test</scope>
 			</dependency>
 		</dependencies>
 		<!-- add plugins for customization -->
 	</project>
 ```
 * Project name, version etc Output file type: JAR, WAR, ...
 * List of projects we depend on Spring, Hibernate, etc...
 * Additional custom tasks to run: generate JUnit test reports etc...

 #### Project Coordinates

 * Project Coordinates uniquely identity a project
 	* Similar to GPS coordinates for your house: latitude / longitude
 	* Precise info for finding your house (city, street, house #)
 -> Specific how to find your house, similar thing maven identify project.
 
 ```xml
 	<groupId>com.luv2code</groupId>
 	<artifactId>mycoolapp</artifactId>
 	<version>1.0.FINAL</version>
 ```

 ##### Project Coordinates - Elements

 * Group ID -> Name of company, group, or organization convention is to use reverse domain name: com.luv2code
 * Artifact ID -> Name of this project: mycoolapp
 * Version -> A specific release version like: 1.0, 1.6, 2.0 ... If project is under active development then: 1.0-SNAPSHOT

 ##### Example of Project Coordinates


 ```xml
 	<groupId>com.luv2code</groupId>
 	<artifactId>mycoolapp</artifactId>
 	<version>1.0.FINAL</version>
 ```

 ```xml
 	<groupId>org.springframework</groupId>
 	<artifactId>spring-context</artifactId>
 	<version>5.0.0.RELEASE</version>
 ```

  ```xml
 	<groupId>org.hibernate</groupId>
 	<artifactId>hibernate-core</artifactId>
 	<version>5.2.11.Final</version>
 ```

 #### Adding Dependencies

  ```xml
 	<project ...>
 		...
 		<dependencies>
 			<dependency>
 				<groupId>org.springframework</groupId>
			 	<artifactId>spring-context</artifactId>
			 	<version>5.0.0.RELEASE</version>
 			</dependency>
 			<dependency>
 				<groupId>org.hibernate</groupId>
			 	<artifactId>hibernate-core</artifactId>
			 	<version>5.2.11.Final</version>
			 </dependency>
 		</dependencies>
 		...
 	</project>
 ```
 * Maven shopping list, maven go out in the internet and pull down these JAR file also this project and in our application 

 #### Dependency Coordinates

 * To add given dependency project, we need
 	* Group ID, Artifact ID
 	* Version is optional ... 
 		* Best practice is to include the version (repeatable builds) Using DevOps
 * May see this referred to as: GAV
 	* Group ID, Artifact ID and Version

 #### How to Find Dependency Coordinates

 * Option 1: Visit the project page (spring.io, hibernate.org etc)
 * Option 2: Visit http://search.maven.org (easiest approach)

 #### Which repo to search?

 * Start with: search.maven.org
 * Then check: mvnrepository.com

 ### Maven Archetypes

 * Archetypes can be used to create new Maven projects 
 * Contains template files for a given Maven project
 * Think of it as a collection of "starter files" for a project
 	* Java Project, Web Project, etc
 	archetype := starter project

 #### Common Archetypes

 * maven-archetype-quickstart  -> An archetype to generate a sample Maven project.
 * maven-archetype-webapp  ->  An archetype to generate a sample Maven Webapp project

 check out here: http://maven.apache.org/archetypes

 #### Archetypes

 * You can create new projects using Maven Archetypes (starter project)
 	* From the command-line with Maven
 	* From an IDE
 		* Eclipse, IntelliJ, NetBeans etc...

 #### Quickstart Archetype

 * maven-archetype-quickstart contains a sample Maven project

 -> project
 	-> pom.xml
 	-> src/main/java/App.java
 	-> src/test/java/AppTest.java

 #### Webapp Archetype

 * maven-archetype-webapp contains a sample Maven webapp project

 -> project
 	-> pom.xml
 	-> src/main/webapp/index.jsp
 	-> src/test/webapp/WEB-INF/web.xml
 	
 ### Creating a Simple Maven Project

 #### The Game Plan

 * Learn about Eclipse's support for Maven
 * Create a simple Maven Project with Eclipse
 * Explore the generated files and directories
 * Run our App
 * Update the Jave version settings 

 #### Eclipse and Maven

 * Most recent versions of Eclipse have built-in support for Maven
 	* Use the m2eclipse plugin
 * There is no need to download / install Maven separately
 * Can create Maven projects, add dependencies all inside of Eclipse without using the CLI


 ### Maven Repositories

 * So we have the project config file pom.xml that basically shopping list our item we have project maven read this configuration file and maven go out check the local repo if those files are there, if not then maven go to the meven central repository that's remote and grab the file remote repository download it save into the local repo then use to the Build and Run app.

 #### Repository Types

 * Local Repository
 * Central Repository

 ##### Local Repository

 * Located on developer's computer
 	* MS Windows: c:\Users\<users-home-dir>\.m2\repository
 	* Mac and Linux: ~/.m2/repository

 * Maven will search this local repository first
 	* Before going to Maven Central Repository
 	* Your local cache

 ##### Central Repository

 * By default, Maven will search Maven's Central Repository (remote)
 	* https://repo.maven.apache.org/maven2/
 * Requires an Internet connection9
 * Once files are downloaded, they are strored in local repository

 ### Maven Repositories - Additional

 * How to connect other repositories

 #### Additional Repositories

 * Remember how mvnrepository.com can index addtional repositories?

 ##### Why are there Additional Repositories?

 * Some development teams may self-host their Maven projects / JARs
 	* Alpha/Beta release
 	* More control over deployments etc
 	* Other reasons... privacy and security

 #### Accessing Addtional Repositories

 * Maven by default connect to the central repo, how can hooked some to the other repos like spring repo, or Atlassian repo, XWiki Repo

 ##### Taask: Configure Addtional Repositories

 * Step 1: Add atlassian-mail dependency to our project 
 	* This is only available in the Atlassian repository
 * Step 2: Add the Atlassian repository to our pom.xml file

 * I chose a project that is NOT in Maven Central Repo. instead only available project specific repo 

 ###### Step 1: Adding atlassian - mail Dependencies 

 File: pom.xml
  ```xml
 	<groupId>com.atlassian.mail</groupId>
 	<artifactId>atlassian-mail</artifactId>
 	<version>4.0.4</version>
 ```

 ###### Step 2: Adding Repositories

 ```xml
 	<repositories>
 		<!-- By default, will still check Maven Central repo ... then the ones listed here -->
 		<repository>
 			<id>atlassian</id>
 			<name>Atlassian Repository</name>
 			<url>http://maven.atlassian.com/content/repositories/atlassian-public</url>
 		</repository>
 		<!-- Multiple repos are processed in top-down order -->
 		<repository>
 		...
 		</repository>
 	</repositories>
 ```

 ### Maven Repositories - Private

 #### Private Repositories - Use Case

 * Your company has created super-top-secret code modules
 * Would like to share with other development teams at your company
 * But let's keep it private
 * NOT AVAILABLE TO THE PUBLIC

 #### Private Maven Repository

 * You can set up your own private Maven Repository
 	* Secure it with credentials: id/password
 * Create your super-top-secret projects and publish on private repository
 * Your development teams can access your private repository :-) 

 #### Cloud Hosted Solutions

 * If you don't need to self-host internally at your company
 * Cloud hosted solutions are available 
 * Check for:
 	* www.packagecloud.io, www.mymavenrepo.com
 	* Google search: "maven cloud hosts"
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
