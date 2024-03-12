package com.javatechie.spring.actuator.api.health;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InternetHealthMetrics implements HealthIndicator {
  // Health suher like I want to implement. I'm not going to consume any rest
  // resource here. I want to show you like based on My Internet connection of my
  // local machine. If Internet is up, then I want to specify my personal like
  // customize health matrix. If it is of then I want to pass the different
  // message. So let's implement the same Create a class. Health metrics
  @Override
  public Health health() {

    return checkInternet() == true ? Health.up().withDetail("Success code", "Active Internet Connection").build()
        : Health.up().withDetail("Error code", "InActive Internet Connection").build();
  }

  private boolean checkInternet() {
    boolean flag = false;

    try {
      URL url = new URL("https://www.google.com");
      URLConnection connection = url.openConnection();
      connection.connect();
      flag = true;
    } catch (Exception e) {
      // TODO: handle exception
      flag = false;
    }
    return flag;
  }
}
