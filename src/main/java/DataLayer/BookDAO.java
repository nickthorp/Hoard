package DataLayer;

import org.hibernate.Session;

import java.awt.print.Book;

/**
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
}
