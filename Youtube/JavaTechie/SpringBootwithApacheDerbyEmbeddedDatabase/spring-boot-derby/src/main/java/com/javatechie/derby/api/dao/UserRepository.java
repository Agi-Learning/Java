package com.javatechie.derby.api.dao;

import com.javatechie.derby.api.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
  User findByName(String name);
}
