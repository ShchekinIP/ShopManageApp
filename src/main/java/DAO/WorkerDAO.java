package DAO;

import Entity.ShopEntity;
import Entity.WorkerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class WorkerDAO {
    public static WorkerEntity findById(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(WorkerEntity.class, id);
        }
    }

    public static void insertWorker(int idShop, WorkerEntity workerEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            ShopEntity shopEntity = session.get(ShopEntity.class, idShop);
            shopEntity.addWorker(workerEntity);
            workerEntity.setShopEntity(shopEntity);
            session.update(shopEntity);
            session.save(workerEntity);
            tx1.commit();

        }
    }

    public static void updateWorker(WorkerEntity workerEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(workerEntity);
            tx1.commit();

        }
    }

    public static void deleteWorker(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(session.get(WorkerEntity.class,id));
            tx1.commit();
        }
    }

    public static List<WorkerEntity> selectWorkers() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.createQuery("from WorkerEntity ").list();
        }
    }
}

