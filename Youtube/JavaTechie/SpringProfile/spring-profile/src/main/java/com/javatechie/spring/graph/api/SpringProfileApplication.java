package com.javatechie.spring.graph.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProfileApplication {

  // It should not be empty. This is the case of value. Should not be empty. By default, we are considering as local. So now let us see from which database the data is switching. Yes, it is switching from local. So So in this code, suppose the Ohh cute people raised a ball and. That is, the bug is only in qn. But in Dave Environment, or my local environment, it is working fine. So in that case, in normal approach, we should write our own properties field. And the existing properties field, you need to change the This is some hard coded data. But in real time, same syntax is not using like same schema and same. major name password is not using for different environment. So there we need to change the entire Configuration details. Not only this data is written in all the endpoint url of rest api, we are configuring in properties file. So in qa environment, it is different. And our production environment also, it is different. Url. So to check in Q Environment, find out the Root Causeway, we need to point All the url and this configuration to Q Environment. So now, what? What? How it optimize? We have created three properties file with different, different. Configuration details. So which profile we are making active in our default properties file only that environment is going to execute similarly. Assume I wrote, This is some dummy service. Azumi wrote shager implementation in this service. And here I mentioned that service I mentioned, the this profile features. Suppose I want to enable this again in Dave Environment. Then in aspirin, this application dot property, spring .profiles dot active, we should mention that. Then only it will display in day environment in QA. It will, they can access it. So this is the way we can switch the environment in our spring application.
  public static void main(String[] args) {
    SpringApplication.run(SpringProfileApplication.class, args);
  }
}
