package com.javatechie.consul.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value = MyConfig.class)
/* Dot class. OK, so in my config class appropriated to variable username and password with same Tamil case, which we mention in our tool. Ok, password and user name. It is inside. Config, Java, Tabatha is my application name. And config is my configuration folder. So let me save this file You will be doing it. Let us run this application.  */
public class SpringBootConsulApplication {
  @Autowired
  private MyConfig config;

  @GetMapping("/getConfigData")
  public MyConfig getConfiguration() {
    return config;
  }

  /* That's it about this particular video you will learn how we can make our common configuration as centralized, so that other microservices can make a access of it, and how we can dynamically change the properties at runtime, ok */
  public static void main(String[] args) {
    SpringApplication.run(SpringBootConsulApplication.class, args);
  }
}
