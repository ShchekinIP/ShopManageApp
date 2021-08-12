package DAO;


import Entity.IncomeEntity;
import Entity.ShopEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class IncomeDAO {
    public static IncomeEntity findById(int id){
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(IncomeEntity.class, id);
        }
    }

    public static void insertIncome(int idShop, IncomeEntity incomeEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            ShopEntity shopEntity = session.get(ShopEntity.class, idShop);
            shopEntity.addIncome(incomeEntity);
            incomeEntity.setShopEntity(shopEntity);
            session.update(shopEntity);
            session.save(incomeEntity);
            tx1.commit();

        }
    }

    public static void updateIncome(IncomeEntity incomeEntity) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(incomeEntity);
            tx1.commit();

        }
    }

    public static void deleteIncome(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.delete(session.get(IncomeEntity.class,id));
            tx1.commit();

        }
    }

    public static List<IncomeEntity> selectIncomes(){
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()){
            return session.createQuery("from IncomeEntity").list();

        }
    }
}
