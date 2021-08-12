package DAO;

import Entity.OutlayEntity;
import Entity.ShipmentEntity;
import Entity.ShopEntity;
import Entity.WorkerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class OutlayDAO {
    public static OutlayEntity findById(int id) {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(OutlayEntity.class, id);
        }

    }

    public static void insertOutlay(int idShop, int idShipment, OutlayEntity outlayEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            ShopEntity shopEntity = session.get(ShopEntity.class, idShop);
            ShipmentEntity shipmentEntity = session.get(ShipmentEntity.class, idShipment);
            shopEntity.addOutlay(outlayEntity);
            shipmentEntity.addOutlay(outlayEntity);
            outlayEntity.setShopEntity(shopEntity);
            outlayEntity.setShipmentEntity(shipmentEntity);
            session.update(shopEntity);
            session.update(shipmentEntity);
            session.save(outlayEntity);
            tx1.commit();
        }
    }

    public static void updateOutlay(OutlayEntity outlayEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(outlayEntity);
            tx1.commit();

        }
    }

    public static void deleteOutlay(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.delete(session.get(OutlayEntity.class, id));
            transaction.commit();
        }
    }

    public static List<OutlayEntity> selectOutlays() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("from OutlayEntity ").list();
        }
    }
}
