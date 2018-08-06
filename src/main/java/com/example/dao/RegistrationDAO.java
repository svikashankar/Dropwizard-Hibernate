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

    }

