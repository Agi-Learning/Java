package com.javatechie.spring.security.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  // userDetailsService provided by Spring Security.
  @Autowired
  private UserDetailsService userDetailsService;

  /* Open Declaration Manager Builder so that we can provide our custom user details. So authentication, though we are not going to do any in memory authentication, we are going to do customized authentication using the user detail service, ok? So user details service  */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /* On these two. So for this, if the url coming with slash rest, then authenticate for everyone, for user and admin, it will authenticate. The request will come. For this it will authenticate. If the url comes with secure and the. Is there is admin, then only he can access that. */
    http.csrf().disable();

    http
      .authorizeRequests()
      .antMatchers("/rest/**")
      .authenticated()
      .anyRequest()
      .permitAll()
      .and()
      .authorizeRequests()
      .antMatchers("/secure/**")
      .authenticated()
      .anyRequest()
      .hasAnyRole("ADMIN")
      .and()
      .formLogin()
      .permitAll();
  }

  @Bean
  public BCryptPasswordEncoder encodePWD() {
    return new BCryptPasswordEncoder();
  }
}
