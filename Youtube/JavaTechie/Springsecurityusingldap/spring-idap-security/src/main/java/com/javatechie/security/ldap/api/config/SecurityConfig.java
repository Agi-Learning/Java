package com.javatechie.security.ldap.api.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;

@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  /* Here we need to specify for which method you want to apply the security and the default form login page. So annotate this class as configuration first Then enable global security. Global method security ok. now write http. Dr authorized request. Any request I want to authorize, then specify the fully authenticated OK, then provide the default login for that something form login. OK Now we need to specify the authentication manager authentication Where we can specify the The way you're going to implement the security like elder authentication. And there we are going to specify the patterns and group all those things. So I have that template instead of right. Let me get that. OK.  */

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .anyRequest()
      .fullyAuthenticated()
      .and()
      .formLogin();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    /* And in authentication manager Azure Builder. We are saying Youre going to implement the elder authentication with the. user pattern. OK, this pattern we need to specify in .Ldif file means L dot file. This is the group and we are going to encode the password using Lda password encoder Ok so now we just enable the ldaf security in our application. Now we need to add the lda file. That is the elder file. So before add this file, lets configure few key in our application dot properties file where we are going to specify the domain name and the port of the elder and the file path where we are going to set that dot ldaf file  */
    auth
      .ldapAuthentication()
      .userDnPatterns("uid={0},ou=people")
      .groupSearchBase("ou=groups")
      .contextSource(contextSource())
      .passwordCompare()
      .passwordEncoder(new LdapShaPasswordEncoder())
      .passwordAttribute("userPassword");
  }

  @Bean
  public DefaultSpringSecurityContextSource contextSource() {
    /* Put in that local host. And this is the default word for Elder, ok? And this is the. Womens and arc  */
    return new DefaultSpringSecurityContextSource(
      Arrays.asList("ldap://localhost:8389/"),
      "dc=springframework,dc=org"
    );
  }
}
