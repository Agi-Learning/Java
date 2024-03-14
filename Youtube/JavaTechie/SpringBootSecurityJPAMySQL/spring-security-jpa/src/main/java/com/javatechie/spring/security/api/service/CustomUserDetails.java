package com.javatechie.spring.security.api.service;

import com.javatechie.spring.security.api.model.User;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {
  /**
   *
   */
  private static final long serialVersionUID = 1256711395932122675L;
  private User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    /* And here this is the Grand Authority we are going to provide based on the user name and password, which it will face from the user class. And that user class, we are going to set in this user details. OK, once we'll get the user from this repository, we'll set it manually. So in this method we are going to provide the authority. OK */
    return user
      .getRoles()
      .stream()
      .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
      .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }
}
