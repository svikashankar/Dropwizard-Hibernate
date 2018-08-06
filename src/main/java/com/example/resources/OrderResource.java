package com.example.resources;


import com.example.dao.OrderDAO;
import com.example.entity.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class OrderResource {

    OrderDAO orderDAO;

    public OrderResource(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    @GET
    @UnitOfWork
    public List<Order> getAll(){
        return orderDAO.getAll();
    }
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Order get(@PathParam("id") int id){
        return orderDAO.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") Integer id, @Valid Order order){
        orderDAO.delete(orderDAO.findById(id));
    }

    @POST
    @UnitOfWork
    public Order add(@Valid Order order){
        Order newOrder = orderDAO.insert(order);
        return newOrder;
    }
    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Order update(@PathParam("id") Integer id, @Valid Order order){
        order = order.setId(id);
        orderDAO.update(order);
        return order;
    }
}
