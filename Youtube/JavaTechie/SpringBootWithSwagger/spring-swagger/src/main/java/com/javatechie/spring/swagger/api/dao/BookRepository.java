package com.javatechie.spring.swagger.api.dao;

import com.javatechie.spring.swagger.api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {}
