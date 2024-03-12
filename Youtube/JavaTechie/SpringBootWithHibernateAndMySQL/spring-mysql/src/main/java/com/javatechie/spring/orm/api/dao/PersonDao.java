package com.javatechie.spring.orm.api.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatechie.spring.orm.api.model.Person;

@Repository
// So as we are using the transaction management, I am writing in down layer
// under transactional, but always you should write in. Only you should write in
// our service class. So young service came community with multiple damaging 18
// hours service.Text now write the controller We take a kids
@Transactional
public class PersonDao {

  // So instead of in each request, getting the session object will check whether
  // the currency is exist or not. If not, then only it will return the message.
  // So right now says.
  @Autowired
  private SessionFactory factory;

  public void savePerson(Person person) {
    getSession().save(person);
  }

  @SuppressWarnings("unchecked")
  public List<Person> getPerson() {
    return getSession().createCriteria(Person.class).list();
  }

  private Session getSession() {
    Session session = factory.getCurrentSession();
    if (session == null) {
      session = factory.openSession();
    }
    return session;
  }
}
