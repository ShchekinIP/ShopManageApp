package DAO;

import Entity.ShipmentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class ShipmentDAO {

    public static ShipmentEntity findById(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(ShipmentEntity.class, id);
        }
    }

    public static void insertShipment(ShipmentEntity shipmentEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(shipmentEntity);
            tx1.commit();
        }
    }


    public static void updateShipment(ShipmentEntity shipmentEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(shipmentEntity);
            tx1.commit();
        }
    }

    public static void deleteShipment(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(session.get(ShipmentEntity.class,id));
            tx1.commit();
        }
    }

    public static List<ShipmentEntity> selectShipments() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("from ShipmentEntity ").list();
        }
    }
}
