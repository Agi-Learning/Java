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
  /* Taxing here So now on top of this example, only let's add our custom search. So instead of toss this existing one, let's create a package Com Labradiki ES apa service, ok. Similarly, create one more package called? Configure ok The kids Kanchi. So first we need to write our config there we need to enable the elastic search and we need to inject the elastic search template and node builder So let us create a class  */
  @Autowired
  private CustomerRepository repository;

  @PostMapping("/saveCustomer")
  public int saveCustomer(@RequestBody List<Customer> customers) {
    repository.save(customers);
    return customers.size();
  }

  @GetMapping("/findAll")
  public Iterable<Customer> findAllCustomers() {
    return repository.findAll();
  }

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
