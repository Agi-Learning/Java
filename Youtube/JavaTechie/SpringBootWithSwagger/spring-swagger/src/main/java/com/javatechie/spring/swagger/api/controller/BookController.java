package com.javatechie.spring.swagger.api.controller;

import com.javatechie.spring.swagger.api.model.Book;
import com.javatechie.spring.swagger.api.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Api(value = "Book Service", description = "My Book Service")
public class BookController {
  @Autowired
  private BookService service;

  // The entire application, the spring segment is over on Microservices with three rest and point api. Ok, Each method beam controller is 11. So for that, we need to generate the rest documentation using Sagar so. using Sagar we need to generate the documentation. So for that we need to add some server related dependency. So add these two dependency which is provided by spring to work with server Select me at Okay, now to inform. Sagar dot for this is my controller class. There may be a chance. You write more than two, 3 controller in our one micro. service here for like for testing purpose. I write only one controller So suppose I have five controllers and I want to generate the documentation for 2 control. So in this situation, we need to inform saga that for these two controller only generate the rest documentation. So for this purpose we need to. write some config to inform a server about our document. document generation approach for for which a pay you want to generate like those things you need to mention there So for that let us write one concrete class where we can configure server related things.
  @PostMapping("/save")
  @ApiOperation(value = "store book api")
  public String saveBook(@RequestBody Book book) {
    return service.saveBook(book);
  }

  @ApiOperation(value = "search book api")
  @GetMapping("/searchBook/{bookId}")
  public Book getBook(@PathVariable int bookId) {
    return service.getBook(bookId);
  }

  @DeleteMapping("/deleteBook/{bookId}")
  public List<Book> deleteBook(@PathVariable int bookId) {
    return service.removeBook(bookId);
  }
}
