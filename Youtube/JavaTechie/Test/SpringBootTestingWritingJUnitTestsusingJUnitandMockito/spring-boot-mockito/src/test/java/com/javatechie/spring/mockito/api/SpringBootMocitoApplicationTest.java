package com.javatechie.spring.mockito.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.javatechie.spring.mockito.api.dao.UserRepository;
import com.javatechie.spring.mockito.api.model.User;
import com.javatechie.spring.mockito.api.service.UserService;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMocitoApplicationTest {
  /* And we want to inject the surfacio as we are going to write the test case for service. So united here at the rate of the  */
  @Autowired
  private UserService service;

  @MockBean
  private UserRepository repository;

  /* Now let's write the test case one by one. Let's go to the user service. We have 4 methods, right? Add user, gate users and gate user by address and delete user. So let me write the test case for get users first so that you can get what exactly mocku is doing, ok  */
  @Test
  public void getUsersTest() {
    /* So what do this line mean? So this fuen I am going to call the method, then return the list of data which I mentioned here instead of hit the database. That is why we mark here the repository. So now let us compare it to assert. so here, So here it will give the brindle. Always will give the list of record right so what we can do, what we can compare your just compare with the size Actually, Java. Service dot Where do you just? Could you return the list of features and just want to get the size of it? Okay?  */
    when(repository.findAll())
      .thenReturn(
        Stream
          .of(
            new User(376, "Danile", 31, "USA"),
            new User(958, "Huy", 35, "UK")
          )
          .collect(Collectors.toList())
      );
    assertEquals(2, service.getUsers().size());
  }

  @Test
  public void getUserByAddressTests() {
    String address = "Banglore";
    when(repository.findByAddress(address))
      .thenReturn(
        Stream
          .of(new User(376, "Danile", 31, "USA"))
          .collect(Collectors.toList())
      );
    assertEquals(1, service.getUserbyAddress(address).size());
  }

  @Test
  public void saveUserTest() {
    User user = new User(376, "Panya", 31, "Pune");
    when(repository.save(user)).thenReturn(user);
    assertEquals(user, service.addUser(user));
  }

  @Test
  public void deleteUserTest() {
    User user = new User(999, "Pranya", 33, "Pune");
    service.deleteUser(user);
    verify(repository, times(1)).delete(user);
  }
}
