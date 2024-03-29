package com.javatechie.es.api.service;

import com.javatechie.es.api.model.Customer;
import java.util.List;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class QueryDSLService {
  @Autowired
  private ElasticsearchTemplate template;

  public List<Customer> searchMultiField(String firstname, int age) {
    QueryBuilder query = QueryBuilders
      .boolQuery()
      .must(QueryBuilders.matchQuery("firstname", firstname))
      .must(QueryBuilders.matchQuery("age", age));
    NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
      .withQuery(query)
      .build();
    List<Customer> customers = template.queryForList(
      nativeSearchQuery,
      Customer.class
    );
    return customers;
  }

  /* Unprepopulated search criteria, right? So similar kind of we will do using search query with wild card So it will return list of customer.  */

  public List<Customer> getCustomerSerachData(String input) {
    String search = ".*" + input + ".*";
    SearchQuery searchQuery = new NativeSearchQueryBuilder()
      .withFilter(QueryBuilders.regexpQuery("firstname", search))
      .build();
    List<Customer> customers = template.queryForList(
      searchQuery,
      Customer.class
    );
    return customers;
  }

  /* Now lets write one more nature. Will helps us to search the specific text, which will give us a input from multiple fields. Suppose I am giving some name. It will check from whether it is available in fast name or last name. If it is available in any of them, it will directly return the object. Ok, So write a method, public list of */

  public List<Customer> multiMatchQuery(String text) {
    SearchQuery searchQuery = new NativeSearchQueryBuilder()
      .withQuery(
        QueryBuilders
          .multiMatchQuery(text)
          .field("firstname")
          .field("lastname")
          .type(MultiMatchQueryBuilder.Type.BEST_FIELDS)
      )
      .build();
    List<Customer> customers = template.queryForList(
      searchQuery,
      Customer.class
    );
    return customers;
  }
}
