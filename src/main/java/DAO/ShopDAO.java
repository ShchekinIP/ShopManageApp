package DAO;

import Entity.ShopEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class ShopDAO {

    public static ShopEntity findById(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(ShopEntity.class, id);
        }
    }

    public static void insertShop(ShopEntity shopEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(shopEntity);
            tx1.commit();
        }
    }

    public static void updateShp(ShopEntity shopEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            Transaction tx1 = session.beginTransaction();
            session.update(shopEntity);
            tx1.commit();
        }
    }

    public static void deleteShop(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.delete(session.get(ShopEntity.class,id));
            transaction.commit();
        }
    }

    public static List<ShopEntity> selectShops() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return (List<ShopEntity>) session.createQuery("from ShopEntity").list();
        }
    }
}
