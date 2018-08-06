package com.example.dao;

import com.example.entity.Person;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDAO extends AbstractDAO<Person> {
//It contain all DB related property details pulled from either hibernate.cfg.xml file or hibernate
    public PersonDAO(SessionFactory factory) {
        super(factory);
    }
//currentSession=returns current session.
//     createCriteria() method,which can be used to create a Criteria object that returns instances of the persistence object's class when your application executes a criteria query.
    public List<Person> getAll() {
        return (List<Person>) currentSession().createCriteria(Person.class).list();
    }

    public Person findById(int id) {
        return (Person) currentSession().get(Person.class, id);
    }

    public void delete(Person person) {
        currentSession().delete(person);
    }

    public void update(Person person) {
        currentSession().saveOrUpdate(person);
    }

    public Person insert(Person person) {
        return persist(person);
    }
}
