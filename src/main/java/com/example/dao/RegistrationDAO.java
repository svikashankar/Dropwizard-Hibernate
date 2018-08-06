package com.example.dao;

import com.example.entity.Registration;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class RegistrationDAO extends AbstractDAO<Registration> {

    public RegistrationDAO(SessionFactory factory){
        super(factory);
    }
//    public List<Registration> getAll() {
//        return (List<Registration>) currentSession().createCriteria(Registration.class).list();
//    }
        public List<Registration> getAll() {
            return (List<Registration>) currentSession().createCriteria(Registration.class).list();
        }

    public Registration insert(Registration registration){
        return persist(registration);
    }

    public Registration findById(int id) {
        return (Registration) currentSession().get(Registration.class,id);
    }

    public void delete(Registration registration) {
        currentSession().delete(registration);
    }

    public void update(Registration registration){
        currentSession().saveOrUpdate(registration);
    }

    }

