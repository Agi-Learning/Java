package com.javatechie.es.api.config;

import java.io.IOException;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(
  basePackages = "com.javatechie.es.api.repository"
)
public class EsConfig {

  // Now create a bean of node builder, Okay. So no builder is not there. Actually, we are using spring good person to and elastic salesperson seeks. So this spring book 2X is not compatible with our elastic version 6. So here we need to change the version of our springboard. Let's use one .5 .9 ok Let's download the corresponding jar now. add one more dependency. For Java, miming access ok that is JNA Now lets close this palm.

  @Bean
  public NodeBuilder builder() {
    return new NodeBuilder();
  }

  @Bean
  public ElasticsearchOperations elasticsearchTemplate() throws IOException {
    return new ElasticsearchTemplate(builder().local(true).node().client());
  }
}
