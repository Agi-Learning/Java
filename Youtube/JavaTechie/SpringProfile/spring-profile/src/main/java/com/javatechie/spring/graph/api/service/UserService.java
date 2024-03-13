package com.javatechie.spring.graph.api.service;

import com.javatechie.spring.graph.api.dao.UserRepository;
import com.javatechie.spring.graph.api.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = { "local", "dev", "prod" })
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> getUsers() {
    return repository.findAll();
  }
}
