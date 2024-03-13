package com.javatechie.spring.swagger.api.config;

import static springfox.documentation.builders.PathSelectors.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class BookConfig {

  // Bring turmoiltoinform.com to inform the soccer that we want to documentation of types ago and the group name. You can mention I mentioned this is rubber techies, so you can mention any and then. the root URL Into your hero. Here I write book sabbies, but the actual root url we write here only boo. So for this controller only, I want to generate the documentation. Even though I have more five controllers available, but I want for particular this url route url, I want to generate the documentation. So for that, we need to specify the root url here. And I named it as book Sergeant and some descriptions, sample documentation generated using so good to for our. Book rusty trailer. Let's change it Rest FBI and this is the my youtube channel link I ordered. You can add any link. This is group name I added so. You can change according to your business. It's not one or two to keep those same things here only Now we enable Sagar, and we wrote our Micro Service. So now let's taste how it generated documentation for us
  @Bean
  public Docket postsApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .groupName("Java Techie")
      .apiInfo(apiInfo())
      .select()
      .paths(regex("/book.*"))
      .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
      .title("Book Service")
      .description(
        "Sample Documentation Generateed Using SWAGGER2 for our Book Rest API"
      )
      .termsOfServiceUrl(
        "https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ"
      )
      .license("Java_Gyan_Mantra License")
      .licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
      .version("1.0")
      .build();
  }
}
