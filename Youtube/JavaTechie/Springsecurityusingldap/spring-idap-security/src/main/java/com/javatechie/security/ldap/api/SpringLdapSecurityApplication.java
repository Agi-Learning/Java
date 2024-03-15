package com.javatechie.security.ldap.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLdapSecurityApplication {

  /* You can take here is your **** **** bane and your specifying the group and user password is L duck encoded. We only specify in our Config file let me show you. OK, that's why the person is encrypted. So normal the flow, like whenever we are eating our end point as we implemented the security. First, it will goes to our properties file. From properties file based on our class, like the elder file path, it will load that. And whatever credential we are providing. From the default formula in based on that, it will goes to that LDI file. And there it is validating. If the user name and password is matched, it is allow us to execute our rest endpoint, or else it is throwing the exception as a bad credential, ok? So this is how we can implement the lf security in our application. */
  public static void main(String[] args) {
    SpringApplication.run(SpringLdapSecurityApplication.class, args);
  }
}
