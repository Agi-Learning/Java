package com.javatechie.consul.api;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my")
@Data
public class MyConfig {
  private String username;
  private String password;
}
