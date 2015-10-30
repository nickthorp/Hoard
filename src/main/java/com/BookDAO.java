package com;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * BookDAO - Data Access Object for Books
 * Created by Nicholas on 10/28/2015.
 */
public class BookDAO {
    public void deleteAllBooks(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.createQuery("delete from Book").executeUpdate();
        session.close();
    }

    public void saveOrUpdateBooks(Book book){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.saveOrUpdate(book);
        session.flush();
        session.close();
    }

    public List<Book> getAllBooks(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createQuery("from com.Book").list();
        session.close();
        return books;
    }

    public List<Book> getAllBooksForUser(String userEmail){
        String hql = "FROM com.Book E WHERE E.userEmail = :userEmail";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setString("userEmail", userEmail);
        List books = query.list();
        session.close();
        return books;
    }

    public Book getBook(int itemId, String userEmail){
        String hql = "FROM com.Book E WHERE E.itemId = :itemId AND E.userEmail = :userEmail";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        query.setInteger("itemId", itemId);
        query.setString("userEmail", userEmail);
        Book book = (Book) query.uniqueResult();
        session.close();
        return book;
    }
}
