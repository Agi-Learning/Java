package com.javatechie.spring.camel.api;

import java.util.Arrays;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootCamelApplication extends RouteBuilder {

  // this is abstract method we need configure the overridden methods,
  public static void main(String[] args) {
    SpringApplication.run(SpringBootCamelApplication.class, args);
  }

  @Override
  public void configure() throws Exception {
    // move data from one file to another
    System.out.println("Started...");
    // moveAllFile();
    // moveSpecificFile("file3");
    // moveSpecificFileWithBody("Java");
    // fileProcess();
    multiFileProcessor();
    System.out.println("End...");
  }

  public void moveAllFile() {
    from("file:C:/Users/Agilan/Desktop/a?noop=true")
      .to("file:C:/Users/Agilan/Desktop/b");
  }

  public void moveSpecificFile(String type) {
    from("file:C:/Users/Agilan/Desktop/a?noop=true")
      .filter(header(Exchange.FILE_NAME).startsWith(type))
      .to("file:C:/Users/Agilan/Desktop/b");
  }

  public void moveSpecificFileWithBody(String content) {
    from(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/source?noop=true"
      )
      .filter(body().startsWith(content))
      .to(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/destination"
      );
  }

  public void fileProcess() {
    from(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/source?noop=true"
      )
      .process(
        p -> {
          String body = p.getIn().getBody(String.class);
          StringBuilder sb = new StringBuilder();
          Arrays
            .stream(body.split(" "))
            .forEach(
              s -> {
                sb.append(s + ",");
              }
            );
          p.getIn().setBody(sb);
        }
      )
      .to(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/destination?fileName=records.csv"
      );
  }

  /* Multi Process of prison for Rajeev I have a banker application. And then my bank application source folder. I have a file. What's your name mode ok? Hermannmorgue.txtare the extension I. have the name. I have the user id, something like this one. The name Unstatus whether the like credit amount is pending or like closed or it's like in interest mode. OK, so closed. OK. some ID. Santos pending ok. so my ID Sourav. Interestpaymentmode.taste some Bianca application, the bank employee exported this format. This is the CSV. Assume we don't have comma here and I. want to separate the files based on the closed I want to generate one file based on the pending user I have to generate one more file. Similarly for interest user So for that we will write the business using the process. How we can differentiate the file based on our like multiple file process With different filter so. that  */
  public void multiFileProcessor() {
    from(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/source?noop=true"
      )
      .unmarshal()
      .csv()
      .split(body().tokenize(","))
      .choice()
      .when(body().contains("Closed"))
      .to(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/destination?fileName=Closed.csv"
      )
      .when(body().contains("Pending"))
      .to(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/destination?fileName=Pending.csv"
      )
      .when(body().contains("Interest"))
      .to(
        "file:SpringBootWithApacheCamelIntegration/spring-boot-camel/destination?fileName=Interest.csv"
      );
  }
}
