package com.javatechie.spring.mockito.api.controller;

import com.javatechie.spring.mockito.api.model.User;
import com.javatechie.spring.mockito.api.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  /* One is for save user Anatomy helps to find all users. and find user by address on method is there and you have the method removing them. I have the three layer control and here is my service Ok and here is my three positive I am using Mongodb here, so that is why I extends from Mongo repository in the. in this example we are going to write the test case for our user service and we are going to mark the data of our user repository means we know it to feed the database. Instead of getting the actual data from db, we will just bypass. We just mopped the data and returned a tab to our service. Ok, ok, so let's write test case now. It was going to write a test case. I want to convey your like already. I uploaded one video. Have to write a test case for your controller using mock it on, but the approach is being different. They are a huge mock nvc. Mock mvc also part of the mocket of cinema. If India are not aware and please check my youtube list */
  @Autowired
  private UserService service;

  @PostMapping(value = "/save")
  public User saveUser(@RequestBody User user) {
    return service.addUser(user);
  }

  @GetMapping("/getUsers")
  public List<User> findAllUsers() {
    return service.getUsers();
  }

  @GetMapping("/getUserByAddress/{address}")
  public List<User> findUserByAddress(@PathVariable String address) {
    return service.getUserbyAddress(address);
  }

  @DeleteMapping(value = "/remove")
  public User removeUser(@RequestBody User user) {
    service.deleteUser(user);
    return user;
  }
}
