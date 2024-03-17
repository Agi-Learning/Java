package com.javatechie.spring.boot.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
@EnableAdminServer
@Configuration
public class SpringBootAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootAdminApplication.class, args);
  }

  @Configuration
  public static class SecurityConfig extends WebSecurityConfigurerAdapter {

    /* So security config is a class, and we extend it from security configure adapter, where you overwrite the configure method. This configure is overloaded method. So and we provided the augmented into P security, where we specify the login page and login url The Logan TVRN and these are our aunt matures This is also to act matters like for every request you want to authenticate. Thats why we specify slash **. This is for our UA united adventures and look for all we want to permit with authenticated  */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .formLogin()
        .loginPage("/login.html")
        .loginProcessingUrl("/login")
        .permitAll();
      http.logout().logoutUrl("/logout");
      http.csrf().disable();

      http
        .authorizeRequests()
        .antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**")
        .permitAll();
      http.authorizeRequests().antMatchers("/**").authenticated();

      http.httpBasic();
    }
  }
}
