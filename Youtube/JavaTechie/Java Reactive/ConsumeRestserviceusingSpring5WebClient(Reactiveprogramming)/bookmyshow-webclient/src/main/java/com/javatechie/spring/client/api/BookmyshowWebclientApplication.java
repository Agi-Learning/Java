package com.javatechie.spring.client.api;

import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/bookMyShow-client")
public class BookmyshowWebclientApplication {
  /* When is the book nice or probed up on Europe? Bookmyshow work client with this client will invoke this bookmyshow using spring thigh reactive programming web client. Ok. So if anyone not aware of it, you can check the video playlist So this is the video I uploaded yesterday, so you can go through it once. Even code is available on our heat Ok so this is the part 2 of 4th client, where we just want to add the. Locking mechanism and exceptional. So logging here are going to apply using exchange rate of that will be implemented like three courses, logic and post process logic. It's a request coming to our endpoint. It will add the looking mechanism. And after getting the response, it will add the post processing login. So let's do that now. We are going to modify this existing code, which we do in previous tutorial So let's write two method. One to capture the request and another one to capture the response, because you need to make it private method. And we. are going to use here. Filter The disproportionate one reclaimed. There is a class called exchange filter function.  */

  Logger log = LoggerFactory.getLogger(BookmyshowWebclientApplication.class);
  WebClient webClient;

  /* This post one as I told this is the filter which we call. First come to this book now before the and after getting the response. So let's add it here. Shut up Then I have your one more filter, create the loud response In our every request and response have console here specifiy any appender */
  @PostConstruct
  public void init() {
    webClient =
      WebClient
        .builder()
        .baseUrl("http://localhost:9090/BookMyShow/Service")
        .defaultHeader(
          HttpHeaders.CONTENT_TYPE,
          MediaType.APPLICATION_JSON_VALUE
        )
        .filter(logRequest())
        .filter(logResponse())
        .build();
  }

  @PostMapping("/bookNow")
  public Mono<String> BookNow(@RequestBody BookRequest request) {
    return webClient
      .post()
      .uri("/bookingShow")
      .syncBody(request)
      .retrieve()
      .bodyToMono(String.class);
  }

  @GetMapping("/trackBookings")
  public Flux<BookRequest> trackAllBooking() {
    return webClient
      .get()
      .uri("/getAllBooking")
      .retrieve()
      .bodyToFlux(BookRequest.class);
  }

  @GetMapping("/trackBooking/{bookingId}")
  public Mono<BookRequest> getBookingById(@PathVariable int bookingId) {
    return webClient
      .get()
      .uri("/getBooking/" + bookingId)
      .retrieve()
      .bodyToMono(BookRequest.class);
  }

  @DeleteMapping("/removeBooking/{bookingId}")
  public Mono<String> cancelBooking(@PathVariable int bookingId) {
    return webClient
      .delete()
      .uri("/cancelBooking/" + bookingId)
      .retrieve()
      .bodyToMono(String.class);
  }

  @PutMapping("/changeBooking/{bookingId}")
  public Mono<BookRequest> updateBooking(
    @PathVariable int bookingId,
    @RequestBody BookRequest request
  ) {
    return webClient
      .put()
      .uri("/updateBooking/" + bookingId)
      .syncBody(request)
      .retrieve()
      .onStatus(
        HttpStatus::is4xxClientError,
        clientResponse ->
          Mono.error(new BookMyShowClientException("404 Unsupported Exception"))
      )
      .onStatus(
        HttpStatus::is5xxServerError,
        clientResponse ->
          Mono.error(new BookMyShowClientException("505 Server Exception"))
      )
      .bodyToMono(BookRequest.class);
  }

  private ExchangeFilterFunction logRequest() {
    return ExchangeFilterFunction.ofRequestProcessor(
      clientRequest -> {
        /* The system will take itself for sale, allowing to industry and coordination based on dynamic equipment Just need to pass the object which you want to log Now lets directly return.  */
        log.info("Request{} {}", clientRequest.method(), clientRequest.url());
        return Mono.just(clientRequest);
      }
    );
  }

  private ExchangeFilterFunction logResponse() {
    return ExchangeFilterFunction.ofResponseProcessor(
      clientResponse -> {
        /* The system will take itself for sale, allowing to industry and coordination based on dynamic equipment Just need to pass the object which you want to log Now lets directly return.  */
        log.info("Response status code {} {}", clientResponse.statusCode());
        return Mono.just(clientResponse);
      }
    );
  }

  public static void main(String[] args) {
    SpringApplication.run(BookmyshowWebclientApplication.class, args);
  }
}
