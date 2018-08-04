package com.example;

import com.example.dao.OrderDAO;
import com.example.dao.PersonDAO;
import com.example.dao.PriceDAO;
import com.example.resources.OrderResource;
import com.example.resources.PersonResource;
import com.example.resources.PriceResource;
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

        final PriceDAO priceDAO =new PriceDAO((hibernate.getSessionFactory()));

        final PriceResource priceResource = new PriceResource(priceDAO);

        final OrderDAO orderDAO = new OrderDAO(hibernate.getSessionFactory());
      final OrderResource orderResource = new OrderResource(orderDAO);

//        final TableTest1DAO test1Dao = new TableTest1DAO(hibernate.getSessionFactory());
//        final TableTest1Resource test1Resource = new TableTest1Resource(test1Dao);

//        final OrderDAO orderDAO =new OrderDAO((hibernate.getSessionFactory()));
//
//        final OrderResource orderResource = new OrderResource(orderDAO);

        environment.jersey().register(personResource);
        environment.jersey().register(priceResource);
        environment.jersey().register(orderResource);
   }
}