package com.javatechie.spring.exp.handle.api.dao;

import com.javatechie.spring.exp.handle.api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
  Order findByName(String name);
}
