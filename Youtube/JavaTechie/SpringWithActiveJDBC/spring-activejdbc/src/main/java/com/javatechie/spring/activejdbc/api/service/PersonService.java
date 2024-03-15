package com.javatechie.spring.activejdbc.api.service;

import com.javatechie.spring.activejdbc.model.InputRequest;
import com.javatechie.spring.activejdbc.model.Person;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  // Write a method to insert records into the database

  public String insert(InputRequest request) {
    Person person = new Person();
    person.set("id", request.getId());
    person.set("first_name", request.getFirstName());
    person.set("last_name", request.getLastName());
    boolean flag = person.insert();
    return "Record inserted : " + flag;
  }

  public List<Person> getPerson(String lastName) {
    // This should be the time parameter it will return the list of person record
    List<Person> persons = Person.where("last_name=?", lastName);
    System.out.println(persons);
    return persons;
  }

  public List<Person> getPersons() {
    return Person.findAll();
  }

  public String delete(String firstName) {
    int no = Person.delete("first_name=?", firstName);
    return no + "record deleted ";
  }

  public String deleteAll() {
    return "deletd " + Person.deleteAll();
  }
}
