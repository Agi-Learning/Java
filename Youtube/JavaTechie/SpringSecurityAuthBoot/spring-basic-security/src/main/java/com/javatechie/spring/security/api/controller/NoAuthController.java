package com.javatechie.spring.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// I have one more controller, and in this application controller only, I want to implement the security for other controller. I don't want to implement the security. So for that case, how we can do so in that case we can do using the URL based security pattern. So let me create one more control load so that I will show you.

@RestController
@RequestMapping("/noAuth/rest")
public class NoAuthController {

  @GetMapping("/sayHi")
  public String sayHi() {
    return "hi";
  }
}
