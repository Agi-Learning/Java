package com.javatechie.spring.mongo.embedded.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
  private String city;
  private String state;
  private String pincode;
}
