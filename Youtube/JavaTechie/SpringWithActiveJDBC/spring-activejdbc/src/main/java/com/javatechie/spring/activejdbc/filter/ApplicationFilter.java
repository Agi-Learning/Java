package com.javatechie.spring.activejdbc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApplicationFilter implements Filter {
  /* Explain in block two way we can create the database connection. 1 engine based under imaging did the whenever we are using one single table single database we should go for base to create the connection in active JVC. If I am working on multiple database then we should go for the degree. New degree default there, you need to pass the username password and all the required fields. So as here I am going to work using one database so I am using base. There is a simple method in base like. base dot open means it will open the conduction here. You need to pass the driver class name url user name and password. Similar way Pastor clothes it will close the convection Make similar pays to commit transaction. This is the predefined method provided by base. So I have this open connection and close connection logic. So let's copy paste that. */
  Logger LOGGER = LoggerFactory.getLogger(ApplicationFilter.class);

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    System.out.println("Resource opened....");
  }

  @Override
  public void doFilter(
    ServletRequest req,
    ServletResponse resp,
    FilterChain chain
  )
    throws IOException, ServletException {
    long before = System.currentTimeMillis();
    try {
      Base.open(
        "com.mysql.jdbc.Driver",
        "jdbc:mysql://localhost:3306/test?useSSL=false",
        "root",
        "Agilan@1"
      );
      Base.openTransaction();
      chain.doFilter(req, resp);
      Base.commitTransaction();
    } catch (IOException | ServletException e) {
      Base.rollbackTransaction();
      throw e;
    } finally {
      Base.close();
    }
    LOGGER.info(
      "Processing took: {} milliseconds",
      System.currentTimeMillis() - before
    );
  }

  @Override
  public void destroy() {
    System.out.println("Resource closed....");
  }
}
