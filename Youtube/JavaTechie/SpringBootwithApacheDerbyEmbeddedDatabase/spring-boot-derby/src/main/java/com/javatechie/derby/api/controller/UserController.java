package com.javatechie.derby.api.controller;

import com.javatechie.derby.api.dao.UserRepository;
import com.javatechie.derby.api.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  // Inject dao in your controller
  @Autowired
  private UserRepository repository;

  @PostMapping("/saveUsers")
  public String saveUser(@RequestBody List<User> users) {
    repository.saveAll(users);
    return users.size() + " record saved..";
  }

  @GetMapping("/getAll")
  public List<User> getAllUsers() {
    return (List<User>) repository.findAll();
  }

  @GetMapping("/getUserByName/{name}")
  public User findUserByName(@PathVariable String name) {
    // spring data jpa, using it feild you can write a method it will behave like a select * from user table where name=runtime variable.
    return repository.findByName(name);
  }
}
