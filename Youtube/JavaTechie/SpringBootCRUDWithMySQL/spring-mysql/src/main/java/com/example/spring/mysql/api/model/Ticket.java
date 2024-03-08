package com.example.spring.mysql.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Ticket")
// We added the properties in model class but we didn't read getters/setters so
// as I added Lombok let use write the annotation getter,setter.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ticket {
  @Id
  @GeneratedValue
  private int id;
  private double amount;
  private String catagory;

}