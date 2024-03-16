package com.javatechie.spring.jdbi.api.repository;

import com.javatechie.spring.jdbi.api.model.Order;
import java.sql.Connection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
  /* Puneet Shoppers create this refusal to devote class. You need to write one map for class who will help to get the data from the database using results set So for that, lets create a class Order Nepal.  */

  @Autowired
  @Qualifier("dataSource")
  private DataSource dataSource;

  Connection connection = null;
  Handle handle = null;
  OrderSQL orderSQL = null;

  @PostConstruct
  public void init() {
    connection = DataSourceUtils.getConnection(dataSource);
    handle = DBI.open(connection);
    orderSQL = handle.attach(OrderSQL.class);
  }

  /* This is the interface and handle that attacks you are giving our order a school where we wrote our all poories, and from interface you are directly all the method, ok? So similarly, write a method for insert on.  */
  public List<Order> findAllOrders() {
    return orderSQL.getOrders();
  }

  public Integer addOrder(Order order) {
    return orderSQL.addProduct(order);
  }

  public List<Order> getOrderByPrice(int price) {
    return orderSQL.getOrderByPrice(price);
  }
}
