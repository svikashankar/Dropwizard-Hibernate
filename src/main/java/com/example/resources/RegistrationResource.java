package com.example.resources;

import com.example.dao.RegistrationDAO;
import com.example.entity.Registration;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
