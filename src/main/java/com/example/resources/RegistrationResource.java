package com.example.resources;

import com.example.dao.RegistrationDAO;
import com.example.entity.Order;
import com.example.entity.Registration;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/register")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class RegistrationResource {

    RegistrationDAO registrationDAO;


    public RegistrationResource(RegistrationDAO registrationDAO){
        this.registrationDAO=registrationDAO;
    }

    @GET
    @UnitOfWork
    public List<Registration> getAll(){
        return registrationDAO.getAll();
    }

    @POST
    @UnitOfWork
    public Registration add(@Valid Registration registration){
        Registration newOrder = registrationDAO.insert(registration);
        return newOrder;
    }
}
