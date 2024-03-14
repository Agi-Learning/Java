package com.javatechie.spring.security.api.repository;

import com.javatechie.spring.security.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsername(String username);
}
