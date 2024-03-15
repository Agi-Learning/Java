package com.javatechie.spring.exp.handle.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderError {
  private int errorCode;
  private String errorMessage;
}
