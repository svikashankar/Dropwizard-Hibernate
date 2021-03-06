package com.example;

import com.example.dao.OrderDAO;
import com.example.dao.PersonDAO;
import com.example.dao.PriceDAO;
import com.example.dao.RegistrationDAO;
import com.example.resources.OrderResource;
import com.example.resources.PersonResource;
import com.example.resources.PriceResource;
import com.example.resources.RegistrationResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ExampleApplication extends Application<ExampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    private final HibernateBundle<ExampleConfiguration> hibernate =
            new ScanningHibernateBundle<ExampleConfiguration>("com.example.entity") {
        @Override
        public DataSourceFactory getDataSourceFactory(ExampleConfiguration configuration) {
            return configuration.getDatabaseAppDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "dropwizard-hibernate";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(ExampleConfiguration configuration, Environment environment) throws ClassNotFoundException {

        final PersonDAO personDAO = new PersonDAO(hibernate.getSessionFactory());


        final PersonResource personResource = new PersonResource(personDAO);
        environment.jersey().register(personResource);

        final PriceDAO priceDAO =new PriceDAO((hibernate.getSessionFactory()));

        final PriceResource priceResource = new PriceResource(priceDAO);
        environment.jersey().register(priceResource);

        final OrderDAO orderDAO = new OrderDAO(hibernate.getSessionFactory());
      final OrderResource orderResource = new OrderResource(orderDAO);
        environment.jersey().register(orderResource);

        final RegistrationDAO registrationDAO= new RegistrationDAO(hibernate.getSessionFactory());
        final RegistrationResource registrationResource=new RegistrationResource(registrationDAO);
        environment.jersey().register(registrationResource);

   }
}