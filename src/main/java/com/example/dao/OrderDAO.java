package com.example.dao;

import com.example.entity.Order;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrderDAO extends AbstractDAO<Order> {

    public OrderDAO(SessionFactory factory){
        super(factory);
    }

    public List<Order> getAll(){

            return (List<Order>) currentSession().createCriteria(Order.class).list();

        }

    public Order findById(int id) {
        return (Order) currentSession().get(Order.class,id);
    }

    public void delete(Order order) {
        currentSession().delete(order);
    }

    public Order insert(Order order){
        return persist(order);
    }
    public void update(Order order){
        currentSession().saveOrUpdate(order);
    }

    }

