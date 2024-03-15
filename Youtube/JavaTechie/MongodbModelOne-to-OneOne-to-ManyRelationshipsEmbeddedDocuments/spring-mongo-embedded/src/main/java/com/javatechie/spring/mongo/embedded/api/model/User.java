package com.javatechie.spring.mongo.embedded.api.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.tomcat.jni.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "order_DB")
public class User {
  @Id
  private int id;

  private String name;
  private String gender;
  private List<Product> products;
  private Address address;
}
