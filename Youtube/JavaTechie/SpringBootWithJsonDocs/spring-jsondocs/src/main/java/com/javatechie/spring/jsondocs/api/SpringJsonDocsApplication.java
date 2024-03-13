package com.javatechie.spring.jsondocs.api;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableJSONDoc
// So here you need to infer the sound of to scan. This is my controller. This is my model, and this is the flow. So you need to speak on the person which we are using. These things we need to inform to Json Doc then only Json Docs will generate the html documentation for us. So we. can we follow the multiple approaches? We can write the Yml file, or we can use the Java based config. So here I am using the.
@ComponentScan(basePackages = "com.javatechie.spring.jsondocs.api")
public class SpringJsonDocsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringJsonDocsApplication.class, args);
  }
}
