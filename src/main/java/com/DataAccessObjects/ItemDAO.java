package com.DataAccessObjects;

import com.DataObjects.Item;
import com.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Nicholas on 11/24/2015.
 */
public class ItemDAO {

    private static volatile ItemDAO instance = null;

    public static synchronized ItemDAO getInstance(){
        if (instance == null)
            instance = new ItemDAO();
        return instance;
    }

    public void deleteAllItems(String table){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.createQuery("delete from " + table).executeUpdate();
        session.close();
    }

    public void saveOrUpdateItems(Item item){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.saveOrUpdate(item);
        session.flush();
        session.close();
    }

    public List<Item> getAllItems(String table){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Item> items = session.createQuery("from com.DataObjects." + table).list();
        session.close();
        return items;
    }

    public List<Item> getAllItemsForUser(String table, String userEmail){
        String hql = "FROM com.DataObjects." + table +
                " E WHERE E.userEmail = :userEmail";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setString("userEmail", userEmail);
        List items = query.list();
        session.close();
        return items;
    }

    public Item getItem(String table, int itemId, String userEmail){
        String hql = "FROM com.DataObjects." + table +
                " E WHERE E.itemId = :itemId AND E.userEmail = :userEmail";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setInteger("itemId", itemId);
        query.setString("userEmail", userEmail);
        Item item = (Item) query.uniqueResult();
        session.close();
        return item;
    }

    public Item deleteItem(String table, int itemId, String userEmail){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Item item = getItem(table, itemId, userEmail);
        session.delete(item);
        session.flush();
        session.close();
        return item;
    }
}
