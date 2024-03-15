package com.javatechie.spring.exp.handle.api.controller;

import com.javatechie.spring.exp.handle.api.exception.OrderServiceException;
import com.javatechie.spring.exp.handle.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  @Autowired
  private OrderService service;

  /* I did some mistake in my input parameter let's. take it bikes Okay. So based on bikes, we dont have any object in database. So when you are calling in this dow in service Heroes giving the null and null dot gate amount is null, but exemption. So in this case, ah, it's difficult to identify the Root Causeway. Null Pointer exception means I need to debug my application and I need to find out the root cause for that. Even it is difficult for the end age of to understand what is null factor, except for so that here, in this scenario, we should go for the exception handling. So let us do that how we can do the. Exception handling.  */
  @GetMapping("/getPrice/{productName}")
  public String getOrderPrice(@PathVariable String productName)
    throws OrderServiceException {
    double amount = service.getPrice(productName);
    return "amount for product " + productName + " is " + amount;
  }
}
