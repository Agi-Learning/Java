package com.javatechie.spring.graphql.api.dao;

import com.javatechie.spring.graphql.api.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
  Person findByEmail(String email);
}
