package com.javatechie.es.api.repository;

import com.javatechie.es.api.model.Customer;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/* Like spring that I have in multiple implementation, which we already are Sapiri Puji Tori Mango Repository Casinda Repository. Similarly for elastic search screen data provided on implementation that is elastic source repository through which we can perform the crowd operation. And this electric search repository is extends from elastic search cod repository. And it again, extends from Peggination and sorting repositories. That is why all the shutting related inbuilt method will be available for elastic search repository. Ok, so let us specify the model here. We have the model called customer And the data type of your primary key. In case of customer, we have the primary key string. So we need to specify that data type here Ok so we created mortal and we created the repository. Now let us go to the main application here. Lets unatted at the rate rest controller  */
public interface CustomerRepository
  extends ElasticsearchRepository<Customer, String> {
  List<Customer> findByFirstname(String firstName);
}
