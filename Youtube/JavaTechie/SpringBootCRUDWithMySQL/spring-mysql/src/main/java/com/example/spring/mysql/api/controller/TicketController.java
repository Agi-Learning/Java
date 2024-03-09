package com.example.spring.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mysql.api.dao.TicketDao;
import com.example.spring.mysql.api.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {
  // All the logic to save data in our database, but we didn't provide the our
  // database details like what is my driver class name URL user name password to
  // save business object to my database that. To database related details we can
  // use our properties file normally when we are going to work from spring
  // environment integration the first we need to the datasource inside address or
  // so you need to provide our all for property which is the driver class name
  // URL username password then we need to provide the dialect and so scale and
  // like DL or to like whether you want to create it for every request or you
  // want to update so these are the properties we need to pass so that i will
  // pass here in my application.properties instead of write any configuration and
  // all
  @Autowired
  private TicketDao dao;

  @PostMapping("/bookTickets")
  public String bookTicket(@RequestBody List<Ticket> tickets) {
    dao.save(tickets);
    return "ticket booked : " + tickets.size();
  }

  @GetMapping("/getTickets")
  public List<Ticket> getTickets() {
    return (List<Ticket>) dao.findAll();
  }

}