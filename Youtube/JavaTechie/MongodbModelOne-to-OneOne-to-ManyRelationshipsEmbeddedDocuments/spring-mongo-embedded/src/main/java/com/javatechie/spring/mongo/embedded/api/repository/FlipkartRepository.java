package com.javatechie.spring.mongo.embedded.api.repository;

import com.javatechie.spring.mongo.embedded.api.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FlipkartRepository extends MongoRepository<User, Integer> {
  List<User> findByName(String name);

  /* In address model, there will be field City ok Then specify the runtime parameter. Show based on Shriti and this is the zero index So this index will be passes for the front time, ok So normally, if you'll do the same operation using your traditional mapping association, mapping using annotation. So you need to write a joint statement. So here in single expression, we can get the object as in user object. The address is documented, ok? So  */
  @Query("{'Address.city':?0}")
  List<User> findByCity(String city);
}
