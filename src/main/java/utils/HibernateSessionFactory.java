package utils;

import Entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(IncomeEntity.class);
                configuration.addAnnotatedClass(OutlayEntity.class);
                configuration.addAnnotatedClass(ShipmentEntity.class);
                configuration.addAnnotatedClass(ShopEntity.class);
                configuration.addAnnotatedClass(WorkerEntity.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;


    }
}