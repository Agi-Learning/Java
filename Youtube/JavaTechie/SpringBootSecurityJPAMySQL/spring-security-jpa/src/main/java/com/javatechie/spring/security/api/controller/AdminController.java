package com.javatechie.spring.security.api.controller;

import com.javatechie.spring.security.api.model.User;
import com.javatechie.spring.security.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/auth/")
public class AdminController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  /* And I want this admin controller class only. Admin can add a user. So for that, for this one, I want to provide only admin access. So here in this class, I want to apply the rule based security for application controller. I want to apply the your waste security. So for this control, for this. Second, in going to write the security for roadways, OK.  */
  // @PreAuthorize(
  //   "hasAnyRole('AdminController')"
  // )/* So this method only admin can add that same. I specify this one as your best admin axis, OK.  */
  /*@PreAuthorize("hasAnyRole('ADMIN')")*/
  @PostMapping("/admin/add")
  public String addUserByAdmString(@RequestBody User user) {
    /* We don't want to save the password in the string text, but we're giving us input. Don't want to save the same if I'll get the user from request, and if I'll save in user repository, it will not be an encrypted format. So to make it encrypted, we need to use. Decrypt password and encoder So lets inject that private  */
    String pwd = user.getPassword();
    String encryptPwd = passwordEncoder.encode(pwd);
    user.setPassword(encryptPwd);
    userRepository.save(user);
    return "user added successfully...";
  }

  @PreAuthorize("hasAnyRole('ADMIN')")
  @GetMapping("/admin/all")
  public String securedHello() {
    return "Secured Hello";
  }
}
