package com.example.spring.mysql.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.mysql.api.model.Ticket;

// Ticket dao from CrudRepository taht is an interface provided by a Spring data to easily integrate with any database implementation so if you mark the first parameter is type parameter so here we should pass our model class and this serializable should be the ID a type of a model primary key so
@Repository
public interface TicketDao extends CrudRepository<Ticket, Integer> {

}
