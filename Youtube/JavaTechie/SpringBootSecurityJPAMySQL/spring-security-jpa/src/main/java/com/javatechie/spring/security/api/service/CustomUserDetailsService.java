package com.javatechie.spring.security.api.service;

import com.javatechie.spring.security.api.model.User;
import com.javatechie.spring.security.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/* This class will need to annotate at the rate service. So that is why I should not able to find this class itself, because there is no stereotype annotation. So that is why control is not coming to this one. Let me check It requests the user, and then it will take and it will add, then through Should not return the null It's a tumble. The totals Ganzor customizes to choose which he created ok. as you added Dev tools, server will be able to start  */
@Service
public class CustomUserDetailsService implements UserDetailsService {
  /* Load user by user name will give the user name based on that it will load the user from database. So to connect with database, you need to inject the repository here. Punjab, the repository first you know  */
  @Autowired
  private UserRepository repository;

  /* Usual work OK we will write down. Load user by username and the return debit user details. User details is one more class provided by spring trimmer where we will mention our user name and password by getting the details from the user class. OK, so let's create our one custom user details class. It will load user by the username and ask the return type which user details. This is the interface we created on our custom user details. There it will shed the user, which we found. And in user details, custom user details, we provided the simple authority with the specific rule. or the serial version Okay, now go to the config friend will authorized based on the role first And then I will check with this url waste authority, ok */
  @Override
  public UserDetails loadUserByUsername(String username)
    throws UsernameNotFoundException {
    User user = repository.findByUsername(username);
    CustomUserDetails userDetails = null;
    if (user != null) {
      userDetails = new CustomUserDetails();
      userDetails.setUser(user);
    } else {
      throw new UsernameNotFoundException(
        "User not exist with name : " + username
      );
    }
    return userDetails;
  }
}
