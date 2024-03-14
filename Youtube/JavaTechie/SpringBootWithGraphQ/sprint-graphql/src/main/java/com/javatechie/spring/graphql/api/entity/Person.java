package com.javatechie.spring.graphql.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/* Delete the date of that particular field as part of response. So this application we are going to develop here it is taking the movie 1. That is why I changed it and I am taking the person entity and for that we need to specify one type script that is with the extension graph qls that I will show you how to do. Now let us declare the field in person.  */

@Getter
@Setter
@Entity
public class Person {
  @Id
  private int id;

  private String name;
  private String mobile;
  private String email;
  private String[] address;
}
