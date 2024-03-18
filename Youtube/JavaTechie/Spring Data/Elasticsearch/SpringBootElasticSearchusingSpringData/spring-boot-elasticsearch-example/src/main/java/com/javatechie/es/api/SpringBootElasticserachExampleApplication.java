package com.javatechie.es.api;

import com.javatechie.es.api.model.Customer;
import com.javatechie.es.api.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootElasticserachExampleApplication {
  @Autowired
  private CustomerRepository repository;

  @PostMapping("/saveCustomer")
  public int saveCustomer(@RequestBody List<Customer> customers) {
    repository.saveAll(customers);
    return customers.size();
  }

  @GetMapping("/findAll")
  public Iterable<Customer> findAllCustomers() {
    return repository.findAll();
  }

  /* And in reputation, you don't have the method find by first name. This is the string that I implementation, string that I have unique syntax. Find by is the syntax, and through which field you want to find, that you need to specify that field. Just open to the find Y. So let us create a Method Z over repository. Ok so let me jump it. So we have three methods. One will save list of customer, and it will return the number of record it is same. And one more method we have, we will retrieve all the record from our repository. Ok, similar  */
  @GetMapping("/findByFName/{firstName}")
  public List<Customer> findByFirstName(@PathVariable String firstName) {
    return repository.findByFirstname(firstName);
  }

  public static void main(String[] args) {
    SpringApplication.run(
      SpringBootElasticserachExampleApplication.class,
      args
    );
  }
}
