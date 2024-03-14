package com.javatechie.spring.security.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityJpaApplication {

  /* OK, now let's test the other one, which is the role waste. OK, where is that your name? This one. This is the post method. So we can taste it from the browser. We leave postman who will add the user object and it can be added by a admin. But as per our database, the first user dramatic is admin and Basant is user. So let's try with Basant. Definitely it will throw the access denied. 403. Status code Ok so  */
  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityJpaApplication.class, args);
  }
}
