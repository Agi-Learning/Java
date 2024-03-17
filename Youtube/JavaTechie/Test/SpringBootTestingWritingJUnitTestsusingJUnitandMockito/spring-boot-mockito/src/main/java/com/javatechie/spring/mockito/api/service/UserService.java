package com.javatechie.spring.mockito.api.service;

import com.javatechie.spring.mockito.api.dao.UserRepository;
import com.javatechie.spring.mockito.api.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public User addUser(User user) {
    return repository.save(user);
  }

  public List<User> getUsers() {
    /* Fidelity actually hitting our database of so let me show you my database already. I have 12345 record, ok? And here we are just I put some dummy data, means I'm out the data. So let's go to the controller. Let's go to the service. OK in service will call the repository means it should give my five record, which is available in my database. So just write a previous statement here. Rifting data from Disney. Futures. So we will check your what exactly data it is giving, whether it is giving the actual users data from database, or it is giving our mob data, which we mention in our test. So lets run once again. Test cases success now lets go to the console You can observe your getting data from DP376 the nail taste, tea 1 and usa. To data which we mock here, it is only giving us, right? So it means it is not hitting our database. That is why we mark the repository Let us quickly write the test case for other methods */
    List<User> users = repository.findAll();
    System.out.println("Getting data from DB : " + users);
    return users;
  }

  public List<User> getUserbyAddress(String address) {
    return repository.findByAddress(address);
  }

  public void deleteUser(User user) {
    repository.delete(user);
  }
}
