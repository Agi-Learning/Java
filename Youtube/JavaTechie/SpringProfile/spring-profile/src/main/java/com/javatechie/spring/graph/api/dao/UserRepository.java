package com.javatechie.spring.graph.api.dao;

import com.javatechie.spring.graph.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}
