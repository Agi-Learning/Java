package com.javatechie.spring.graphql.api.controller;

import com.javatechie.spring.graphql.api.dao.PersonRepository;
import com.javatechie.spring.graphql.api.entity.Person;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
  @Autowired
  private PersonRepository repository;

  @Value("classpath:person.graphqls")
  private Resource schemaResource;

  private GraphQL graphQL;

  /* If this runtime hearing to grapple schema This registry and this runtime wiring will give you the graph ql schema so that he will read it and he will be build the that tie script mechanism Good afternoon, skimmer  */
  @PostConstruct
  public void loadSchema() throws IOException {
    File schemaFile = schemaResource.getFile();
    TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
    RuntimeWiring wiring = buildWiring();
    GraphQLSchema schema = new SchemaGenerator()
    .makeExecutableSchema(registry, wiring);
    graphQL = GraphQL.newGraphQL(schema).build();
  }

  /* So here you need to create the data picture. In data picture, we will Will face the data from database and for which method call like we mentioned in typescript Forget all person. We need list of person or client person. We need only one person object that will configure in this runtime wearing using data feature So as that effect is a functional interface, I am writing here. Lambda expression. data feature my class is person OK so  */
  /* So here you need to create the data picture. In data picture, we will Will face the data from database and for which method call like we mentioned in typescript Forget all person. We need list of person or client person. We need only one person object that will configure in this runtime wearing using data feature So as that effect is a functional interface, I am writing here. Lambda expression. data feature my class is person OK so  */

  private RuntimeWiring buildWiring() {
    DataFetcher<List<Person>> fetcher1 = data -> {
      return (List<Person>) repository.findAll();
    };

    DataFetcher<Person> fetcher2 = data -> {
      return repository.findByEmail(data.getArgument("email"));
    };

    return RuntimeWiring
      .newRuntimeWiring()
      .type(
        "Query",
        typeWriting ->
          typeWriting
            .dataFetcher("getAllPerson", fetcher1)
            .dataFetcher("findPerson", fetcher2)
      )
      .build();
  }

  @PostMapping("/addPerson")
  public String addPerson(@RequestBody List<Person> persons) {
    repository.save(persons);
    return "record inserted " + persons.size();
  }

  @GetMapping("/findAllPerson")
  public List<Person> getPersons() {
    return (List<Person>) repository.findAll();
  }

  @PostMapping("/getAll")
  public ResponseEntity<Object> getAll(@RequestBody String query) {
    ExecutionResult result = graphQL.execute(query);
    return new ResponseEntity<Object>(result, HttpStatus.OK);
  }

  @PostMapping("/getPersonByEmail")
  public ResponseEntity<Object> getPersonByEmail(@RequestBody String query) {
    ExecutionResult result = graphQL.execute(query);
    return new ResponseEntity<Object>(result, HttpStatus.OK);
  }
}
