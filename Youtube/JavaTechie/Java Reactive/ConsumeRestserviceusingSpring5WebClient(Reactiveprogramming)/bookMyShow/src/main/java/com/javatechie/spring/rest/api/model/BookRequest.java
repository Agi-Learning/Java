package com.javatechie.spring.rest.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BookMyShow")
public class BookRequest {
  @Id
  @GeneratedValue
  private int bookingId;

  private String userName;
  private String showName;

  @JsonFormat(
    pattern = "dd/MM/yyyy",
    shape = JsonFormat.Shape.STRING,
    timezone = "Asia/Kolkata"
  )
  private Date bookingTime;

  private int userCount;
  private double price;
}
