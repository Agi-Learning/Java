package com.javatechie.spring.batch.api.config;

import com.javatechie.spring.batch.api.data.Person;
import com.javatechie.spring.batch.api.util.MailUtil;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
public class ApplicationConfig {
  // Stephen job this is two factory provided by spring Private batch so we can easily run those steps. So inject them

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  //From database using Mongo. So inject Mongodeau template, once will run this then attend will add the mail features then will trigger the mail.
  @Autowired
  private MongoTemplate template;

  @Autowired
  private MailUtil util;

  // Now it will take care to the read data from database so annotate this @Bean
  @Bean
  public MongoItemReader<Person> reader() {
    MongoItemReader<Person> reader = new MongoItemReader<Person>();
    reader.setTemplate(template);
    reader.setQuery("{}");
    reader.setTargetType(Person.class);
    reader.setSort(
      new HashMap<String, Sort.Direction>() {

        {
          put("_custId", Direction.DESC);
        }
      }
    );
    return reader;
  }

  //Will write it in the form of xml format, so we need to convert object to xml that we can do this converter of object to xml. That is the marsaline we can do using our Jax BFI. But here we will use the stacks. So it will be more faster, and it will be easy to us Ok so starts

  @Bean
  public StaxEventItemWriter<Person> writter() {
    StaxEventItemWriter<Person> writter = new StaxEventItemWriter<Person>();
    // Here we need to specify the path where you want to generate your xml
    writter.setRootTagName("Persons");
    writter.setResource(new FileSystemResource("xml/bank.xml"));
    writter.setMarshaller(marshaller());
    return writter;
  }

  private XStreamMarshaller marshaller() {
    XStreamMarshaller marshaller = new XStreamMarshaller();
    Map<String, Class> map = new HashMap<>();
    map.put("Person", Person.class);
    marshaller.setAliases(map);
    return marshaller;
  }

  // How we configure all the component of our bad job, reader, writer and step and job. Only processor we did not add here. Let's run this application. Check whether the like the xml file is generating or not. Then after that, we will add the Processor and in processor will write the logic. Those status is pending. It will trigger the mail to them. So let's run this application first.
  @Bean
  public Step step1() {
    // U can run multiple step parallely, we need to configure all those step names in our job, Generic forever For which class, though, like the more entity. Then here you need to pass the reader and writer. If you have processor, then you need to pass that, ok? right? Ah,
    return stepBuilderFactory
      .get("step1")
      .<Person, Person>chunk(10)
      .reader(reader())
      .processor(process())
      .writer(writter())
      .build();
  }

  @Bean
  public Job runJob() {
    return jobBuilderFactory
      .get("report generation")
      .flow(step1())
      .end()
      .build();
  }

  public ItemProcessor<Person, Person> process() {
    ItemProcessor<Person, Person> process = new ItemProcessor<Person, Person>() {

      @Override
      public Person process(Person person) throws Exception {
        if (person.getStatus().equalsIgnoreCase("Pending")) {
          String msg = util.sendEmail(person.getEmail(), buildMessage(person));
          System.out.println(msg);
          return person;
        }
        return null;
      }

      private String buildMessage(Person person) {
        String mailBody =
          "Dear " +
          person.getName() +
          "," +
          "\n" +
          "statement of your credit card ending with " +
          person.hashCode() +
          "**" +
          " has been generated" +
          "\n" +
          "dues amount :" +
          person.getOutstandingAmount() +
          "\n" +
          "last payment date : " +
          new SimpleDateFormat("yyyy/MM/dd HH:mm:ss a")
          .format(person.getLastDueDate()) +
          "\n" +
          "\n" +
          "If you already paid please ignore this email" +
          "\n" +
          "Thanks for using our credit card ";
        return mailBody;
      }
    };
    return process;
  }
}
