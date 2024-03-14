package com.javatechie.spring.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

  // So let's n specify this kind of like password in property spread and we can take suppose you want to implement in your application based on you are in. Suppose you want specific URL you want to apply the security. or some specific method you want to apply the security so it cannot be possible by using this one default mechanism or whenever you need something like role based security like few of my api can be accessed by admin or can access by the user. So role by security also you can't mention in this properties file. So now. how we can do the role way security and url way security. Let's check that. Let me command these two, ok? let me stop the server So let's write our customized security configures. So for that, create a case called config. Then we will write
  @GetMapping("/getMsg")
  public String greeting() {
    return "spring security example";
  }
}
