package com.javatechie.spring.jdbi.api.repository;

import com.javatechie.spring.jdbi.api.model.Order;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/* Ok, now let's write a one interface and. inside that interface, based on annotation, will write the query there. And from repudiatory, we can directly call our interface network. So write an interface Audoresque */
@RegisterMapper(value = OrderMapper.class)
public interface OrderSQL {
  // Using annotation you can write the query suppose assume i want to fetch all the order
  @SqlQuery("Select * from Order_TB")
  public List<Order> getOrders();

  @SqlUpdate(
    "insert into Order_TB (order_name,price,quantity,purchaseDate)" +
    "value(:order_name,:price,:quantity,:purchaseDate)"
  )
  @GetGeneratedKeys
  public Integer addProduct(@BindBean Order order);

  @SqlQuery("SELECT * FROM Order_TB WHERE price = :price")
  abstract List<Order> getOrderByPrice(@Bind("price") int price);
  /* Three operations you're going to perform vanish in another one, another two is retrieval operations. Ok. And we write our nap, and we register that map in our order rescue entrance. So now, instead of right to query, we can directly call this entropies Ok, it's already created the repository annotated.  */
}
