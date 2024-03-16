package com.javatechie.spring.jdbi.api;

import com.javatechie.spring.jdbi.api.model.Order;
import com.javatechie.spring.jdbi.api.repository.OrderRepository;
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
public class SpringJDBIExampleApplication {
  /* For now. As this is the jtbi which built in top of jdbc. So in jdbc, there is no auto table creation mechanism So for that manual, you need to create a table. So as we are using spring book in spring book, using s You can generate the table Ok  */
  @Autowired
  private OrderRepository repository;

  @PostMapping("/addOrder")
  public String addOrder(@RequestBody Order order) {
    Integer count = repository.addOrder(order);
    return count + " record saved...";
  }

  @GetMapping("/getOrders")
  public List<Order> getOrders() {
    return repository.findAllOrders();
  }

  @GetMapping("/getOrders/{price}")
  public List<Order> getOrdersByPrice(@PathVariable int price) {
    return repository.getOrderByPrice(price);
  }

  /* Instead of creating interface and analytic advertising on specific you can write similarly, like handled, create curry bind. Then the response type, then attend even to close it So this is the way we can write the functional query, functional programming in jdbi. Ok, you can use the Lambda OK That's what about this thing jdk basic and D1 crowd operation So thats it about this particular video. If anyone have any doubt or concern, you can add a comment. And those will not subscribe yet. Please go ahead and subscribe it. Thanks for watching this video.  */
  public static void main(String[] args) {
    SpringApplication.run(SpringJDBIExampleApplication.class, args);
  }
}
