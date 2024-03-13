package com.javatechie.spring.graph.api.controller;

import com.javatechie.spring.graph.api.model.User;
import com.javatechie.spring.graph.api.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserService service;

  @GetMapping("/findAllUsers")
  public List<User> getUsers() {
    return service.getUsers();
  }
}
