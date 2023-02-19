package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//40. Spring MVC & Hibernate
//
//Full working Spring MVC and Hibernate application that connects to a database
//Check Tab
//
//Customer Relationship Management - CRM
//
// -- So this will basically allow us to track customers So this so we can add new customers, update, delete, and also list all the customers in our db. 
//
//* Set up Database Dev Environment
//* List Customer
//* Add a new Customer
//* Update a Customer
//* Delete a Customer
//
//
//Setup Database Table
//
//Two Database Scripts
//
//1. Folder: sql-scripts
//	* 01-create-user.sql
//	* 02-customer-tracker.sql
//
//-- About: 01-create-user.sql
//
//1. Create a new MySQL user for our application
//	* user id: springstudent
//	* password: springstudent
//
//-- About: 02-customer-tracker.sql
//
//1. Create a new database table: customer
//2. Load table with sample data
//
//Test DB Connection
//
//1. Setup our Eclipse project
//2. Add JDBC Driver for MySQL
//3. Sanity test ... make sure we can connect :-)
//
//Setup Dev Environment
//
//1. Copy starter config files
//	1. web.xml and spring config
//
//2. Copy over JSTL libs
//3. Copy latest Spring JAR files
//4. Copy latest Hibernate JAR files
//
//Configuration for Spring + Hibernate
//
//1. Define database dataSource / connection pool
//2. Setup Hibernate session factory
//3. Setup Hibernate transaction manager
//4. Enable configuration of transactional annotations
//
//Placement of Configurations
//
//Add the following configurations in your Spring MVC configuration file
//
//Step 1: Define database dataSource / connection pool
//
//<bean id="myDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
//		destroy-method="close"> 
//	<property name="driverClass" value="com.mysql.jdbc.Driver" />
//	<property name="jdbcUrl"
//				value="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false" />
//	<propery name="user" value="springstudent" />
//	<propery name="password" value="springstudent" />
//
//	<!-- these are connection pool properties for C3P0 -->
//	<property name="minPoolSize" value="5" />
//	<property name="maxPoolSize" value="20" />
//	<properyt name="maxIdleTime" value="30000" />
//</bean>
//
//connection pool to connecting our database, So top, I setup a been id for myDataSource and then we give the class of the ComboPooledDataSource. 
//Next setup the db conn info, such as the driver class name, the jdbcUrl, user id and pass 
//At the bottom we config the connection pool for c3p0 and we can specify the min pool size, the max pool size, and the max idle time. 
//
//Step 2: Setup Hibernate session factory
//
//<bean id="sessionFactory"
//	class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
//	<property name="dataSource" ref="myDataSource" />
//	<property name="packagesToScan" value="com.luv2code.springdemo.entity" />
//
//	<property name="hibernateProperties">
//		<props>
//			<prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
//			<prop key="hibernate.show_sql">true</prop>
//		</props>
//	</property>
//</bean>
//
//Next setting up the hibernate session factory remember, the session factory is what Hibernate uses to connect to the database. So we set this bean id of sessionFactory. And then for property name=dataSource, we give a ref to myDataSource. That's the dataSource that we defined on the prev slide 
//packages to scan define my entity classes So this will actually scan in a recursive fashion, meaning starting at springdemo.entity, 
//finally we can specify the hibernate props here, mySQLDialect 
//
//Step 3: Setup Hibernate transaction manager
//
//Remember when we write hibernate code we always start a transaction in the transaction and so on. Well, Spring has support where you can actually minimize or actually eliminate that code in you DAO classes. So we'll make use of the Spring framework's Hibernate transaction manager and we simply set it up. we give a ref here to the sessionFactory. Thats the sessionFactory we define on the prev slide. 
//
//<bean id="myTransactionManager"
//	class="org.springframework.orm.hibernate5.HibernateTransactionManager" >
//	<property name="sessionFactory" ref="sessionFactory" />
//</bean>
//
//Step 4: Enable configuration of transactional annotations
//
//<tx:annotation-driven transaction-manager="myTransactionManager" />
//
//Spring provides a special annotation called @Transactional that allows you to minimize or eliminate some of your coding from manually starting and stopping transactions. And we'll see more examples of coding for that 
//
//Test Spring MVC Controller
//
//Check Tab
//Customer Controller
//
//Setup first basic infrastructure, You may have experienced a problem where you write your controller code and it just doesn't work. And it's really nothing with your code involved. It's more of a caching issue with Eclipse or Tomcat. And normally go through and clean your project, restart Tomcat, and then everything will work. So I wanna make sure that, at least, we have our customer controller working first, before we get into all the gory database work, So what we'll do that, 
//We'll actually have this customer controller, It's gonna respond to a request mapping for /customer/list And all it's gonna do inside of its simply gonna forward over to our jsp page list-customer.jsp. Now this jsp page gonna be a shell, there's nothing there. It's really just a placeholder. But i atleast wanna make sure that i have this end to end functionality working. Where our controller is handling requests and then sending it over to the jsp page. 


/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// setup connection variables
		String user = "springstudent";
		String pass = "springstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection to database
		try {
			PrintWriter out = response.getWriter();
			
			out.println("\nConnecting to database: "+ jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("SUCCESS!!");
			
			myConn.close();
			
		} catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	
	}

}
