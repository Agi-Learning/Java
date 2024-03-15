package com.javatechie.spring.exp.handle.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDER_TB")
public class Order {
  @Id
  private int id;

  private String name;
  private String catagory;
  private double amount;
}
