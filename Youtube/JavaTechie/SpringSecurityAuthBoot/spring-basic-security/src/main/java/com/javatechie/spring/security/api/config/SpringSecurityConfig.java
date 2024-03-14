package com.javatechie.spring.security.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication()
      .withUser("Java Techie")
      .password("Password")
      .roles("ADMIN");
    auth
      .inMemoryAuthentication()
      .withUser("Basant")
      .password("Password2")
      .roles("USER");
  }

  // specify the method you want to implement the security
  // security for all api
  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //   http.csrf().disable();
  //   http
  //     .authorizeRequests()
  //     .anyRequest()
  //     .fullyAuthenticated()
  //     .and()
  //     .httpBasic();
  // }

  // Security based on URL
  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //   http.csrf().disable();
  //   http
  //     .authorizeRequests()
  //     .antMatchers("/rest/**")
  //     .fullyAuthenticated()
  //     .and()
  //     .httpBasic();
  // }

  // security based on ROLE
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http
      .authorizeRequests()
      .antMatchers("/rest/**")
      .hasAnyRole("ADMIN")
      .anyRequest()
      .fullyAuthenticated()
      .and()
      .httpBasic();
  }

  // So here we can use that. What is that class? Decrypted that we can use here. But in this case, we are not using any rule base authentication. So to ignore that I added just this deprecated class so that it will not expect the password in encrypted format
  @Bean
  public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
  }
}
