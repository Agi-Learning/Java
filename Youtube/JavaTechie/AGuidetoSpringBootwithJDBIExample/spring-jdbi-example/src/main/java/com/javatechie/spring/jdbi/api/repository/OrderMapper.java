package com.javatechie.spring.jdbi.api.repository;

import com.javatechie.spring.jdbi.api.model.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class OrderMapper implements ResultSetMapper<Order> {

  @Override
  public Order map(int index, ResultSet r, StatementContext ctx)
    throws SQLException {
    /* Maths from results set will extract the value and will feed it on in our model object. Directly and return the Order object here ChhattisgarOn the advantages of this jtb, it supports both in. both index parameter and named parameter, ok, So you may have the all type field Using our map of Ok  */
    return new Order(
      r.getInt("id"),
      r.getString("order_name"),
      r.getInt("price"),
      r.getInt("quantity"),
      r.getDate("purchaseDate")
    );
  }
}
