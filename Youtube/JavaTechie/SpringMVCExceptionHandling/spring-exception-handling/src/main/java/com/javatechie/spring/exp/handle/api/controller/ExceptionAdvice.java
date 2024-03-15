package com.javatechie.spring.exp.handle.api.controller;

import com.javatechie.spring.exp.handle.api.exception.OrderServiceException;
import com.javatechie.spring.exp.handle.api.model.OrderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

  /* Okay. So before do that, we want some proper response, like something like error code and error rate. So for that we should create our own auditio. So take like Odor error. No exception in the name you can write here. Then. You have to pass Exception as a method argument. Ok so that when we got a call exception dot get message, we can map that message in our order error That field error message. so united this method, exception handler, pass your exception class Ok, now create auto ray object.OK what will keep Azer code lets default as like internal server error. So the status code will be 500. You can change it to anyone any. status code you can change. So as if now love let's make it 500 and error message is nothing but message we are returning from our service. This is the end. This we should call the. OK then a return same. New response entity Then pass the error object and mention this status code. OK Now let's run our application. And we will see how the this exception details is mapping as part of our response.   */
  @ExceptionHandler(OrderServiceException.class)
  public ResponseEntity<OrderError> mapException(OrderServiceException ex) {
    OrderError error = new OrderError(
      HttpStatus.INTERNAL_SERVER_ERROR.value(),
      ex.getMessage()
    );
    return new ResponseEntity<OrderError>(
      error,
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
