package com.javatechie.spring.exp.handle.api.service;

import com.javatechie.spring.exp.handle.api.dao.OrderDAO;
import com.javatechie.spring.exp.handle.api.exception.OrderServiceException;
import com.javatechie.spring.exp.handle.api.model.Order;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  @Autowired
  private OrderDAO dao;

  // Here I perform one opertion based on order The name I want to face the order price. OK, so first let's add some tummy order object in our database. I want to catch. Price based on the order name So I want this data to be persist when my application will be up. So that is why I am using post constructor. Same like init method. In xml approves. OK now let's get the
  @PostConstruct
  public void addOrder2DB() {
    List<Order> orders = new ArrayList<>();
    orders.add(new Order(876, "Mobile", "Electronics", 8000));
    orders.add(new Order(806, "Bike", "Veichlie", 90000));
    dao.save(orders);
  }

  // Amount only display not need to take entire objects This is the syntax we need to follow religion spring data JPA without writing query we can achieve. We can get the data from database by method level itself. So this I explain in my previous string data GP video. If anyone not aware on that. Stomachs declare this method.
  public double getPrice(String productName) throws OrderServiceException {
    // Order order = dao.findByName(productName);
    // return order.getAmount();
    Order order = null;
    double amount = 0;
    try {
      order = dao.findByName(productName);
      amount = order.getAmount();
    } catch (Exception e) {
      throw new OrderServiceException(
        "order not found with product : " + productName
      );
    }
    return amount;
  }
}
