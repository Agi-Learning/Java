package com.javatechie.spring.swagger.api.service;

import com.javatechie.spring.swagger.api.dao.BookRepository;
import com.javatechie.spring.swagger.api.model.Book;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
  @Autowired
  private BookRepository repository;

  public String saveBook(Book book) {
    repository.save(book);
    return "book save dwith id " + book.getBookId();
  }

  public Book getBook(int bookId) {
    return repository.findOne(bookId);
  }

  public List<Book> removeBook(int bookId) {
    repository.delete(bookId);
    return repository.findAll();
  }
}
