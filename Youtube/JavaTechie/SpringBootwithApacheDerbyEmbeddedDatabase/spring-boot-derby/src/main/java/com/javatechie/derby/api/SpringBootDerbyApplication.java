package com.javatechie.derby.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDerbyApplication {

  /* These data we currently saved and this data will be available Until my application is up. So once I will up my application, those data will be not available, because it will store in my local memory. So let us check that whether data will be available or not. Lets reun our application.  */
  /* Again, if I'll stop my server, all data will be clean. Ok, so this is the concept of Indiana memory, because for temporary data, which we are using for certain amount of time, like it will not constant to use the business, we should keep those data in our temporary database So similarly, like Darby, there will one more database, that is its 2 database, using that H 2 database also. We can perform this fraud operation and H2 is also one in memory database embedded database. So in my next video I will show you how we can work with H 2 in memory database. So that is it about this particular video. If anyone have any doubt or concern, you can add a comment. Thanks for watching this video  */
  public static void main(String[] args) {
    SpringApplication.run(SpringBootDerbyApplication.class, args);
  }
}
