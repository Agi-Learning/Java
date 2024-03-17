package com.javatechie.spring.mockito.api.dao;

import com.javatechie.spring.mockito.api.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
  List<User> findByAddress(String address);
}
