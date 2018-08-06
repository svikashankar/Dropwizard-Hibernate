package com.example.dao;

import com.example.entity.Person;
import com.example.entity.PriceEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PriceDAO extends AbstractDAO<PriceEntity> {
    public PriceDAO(SessionFactory factory) {
        super(factory);
    }

    public List<PriceEntity> getAll() {
//        String query = "select p from PriceEntity p";
//        return namedQuery(PriceEntity.ALL_PRICE).list();
//        return currentSession().createQuery(query).list();

            return (List<PriceEntity>) currentSession().createCriteria(PriceEntity.class).list();


//        return  criteria().list();
    }
}
