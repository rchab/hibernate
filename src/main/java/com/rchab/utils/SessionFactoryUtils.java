package com.rchab.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryUtils {
    private static final SessionFactory SESSION_FACTORY =  createFactory();

    private static SessionFactory createFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        System.out.println("Session Factory created.");
        return factory;
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

    public static void shutdown(){
        getSessionFactory().close();
        System.out.println("Session Factory closed.");
    }
}
