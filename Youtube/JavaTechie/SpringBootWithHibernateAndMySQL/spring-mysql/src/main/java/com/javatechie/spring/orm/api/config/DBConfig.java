package com.javatechie.spring.orm.api.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class DBConfig {
  // So first I need to add my driver class. You are an user name, password and
  // dialect. So lets copy those things in my properties file. Ok, this is my
  // schema name, and this is my dialect, ok? So now. load that properties failed
  // using property source annotation. The food resource LU equal to this one is
  // the string array Show Class Bath. Application.properties. Ok, now get the
  // value private string Driver class. driver string URL. Private string username
  // and password. Ok so how can we get the value from properties file? There is
  // two way. Either we can use the environment attribute, or else we can use the
  // advert value. So I am using here. Advert value. Ok then plus the
  @Value("${jdbc.driverClassName}")
  private String driverClass;
  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.username}")
  private String username;
  @Value("${jdbc.password}")
  private String password;
  @Value("${hibernate.dialect}")
  private String dialect;

  // Now this value will load from our produce file. So first step, we need to
  // create the data source, ok? that the source.

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
    dataSource.setDriverClassName(driverClass);
    // Now, as we are going to integrate with hibernate, so hybrid have some
    // properties which we need to add that is like dial. and like auto creation of
    // table and the so square. So let's create a properties.
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
    factory.setDataSource(getDataSource());
    factory.setHibernateProperties(hibernateProperties());
    factory.setPackagesToScan(new String[] { "com.javatechie.spring.orm.api.model" });
    return factory;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", dialect);
    properties.put("hibernate.hbm2ddl.auto", "update");
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.format_sql", "true");
    return properties;
  }

  @Bean
  @Autowired
  public HibernateTransactionManager transactionManager(SessionFactory factory) {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(factory);
    return transactionManager;
  }
}
