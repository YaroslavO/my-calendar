package com.yaroslav.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.Stoppable;

/**
 * Created by employee on 5/27/15.
 */

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration
                    .buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public static void close() {
        final SessionFactoryImplementor sessionFactoryImplementor = (SessionFactoryImplementor) sessionFactory;
        ConnectionProvider connectionProvider = sessionFactoryImplementor.getConnectionProvider();
        if (Stoppable.class.isInstance(connectionProvider)) {
            ((Stoppable) connectionProvider).stop();
        }
    }
}
