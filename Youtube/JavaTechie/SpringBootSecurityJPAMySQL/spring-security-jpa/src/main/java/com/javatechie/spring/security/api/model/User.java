package com.javatechie.spring.security.api.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
  @Id
  private int user_id;

  private String username;
  private String password;
  private String email;

  /* set of role in user class So let's do the one to many association between. User and room as a user can have multiple rules so mention here one to many.  */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  /* Now I want to make a separate table between user and rule. I want there to be mapped user id and role id in a separate joint table. So for that write annotation joint. table  */
  @JoinTable(
    name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private Set<Role> roles;
}
