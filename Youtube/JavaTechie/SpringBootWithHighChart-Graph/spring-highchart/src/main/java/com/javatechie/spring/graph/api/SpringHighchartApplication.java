package com.javatechie.spring.graph.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringHighchartApplication extends WebMvcConfigurerAdapter {

  /* Paragraph then it will display the bar graph related qa things. And when I click on pie chart, then it will display the pie chart graph. So for that, initially to provide those link I need one page that I do not want to write the business in control for to display 1 simple ui. So for that, I can use the parameterizable view controller. So for that instance, your class form NBC configure adapter. Then it overwrite that add on to load the controller. Enter here you need to mention the view name and the corresponding url. So register Registered hard view control of insund the url here. I'm mentioning here at home  */

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home");
  }

  public static void main(String[] args) {
    SpringApplication.run(SpringHighchartApplication.class, args);
  }
}
