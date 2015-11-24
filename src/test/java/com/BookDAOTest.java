package com;

import com.DataAccessObjects.BookDAO;
import com.DataObjects.Book;
import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Nicholas on 10/29/2015.
 */
public class BookDAOTest extends TestCase {

    private BookDAO bookDao;
    private Book book;

    public void setUp() throws Exception {
        super.setUp();
        book = new Book();
        book.setItemId(111); book.setUserEmail("email"); book.setTitle("title");
        bookDao = BookDAO.getInstance();
    }

    public void tearDown() throws Exception {
        bookDao.deleteAllBooks();
    }

    public void testDeleteAllBooks() throws Exception {
        bookDao.deleteAllBooks();
        assertThat(bookDao.getAllBooks().size(), is(equalTo(0)));
    }

    public void testSaveOrUpdateBooks() throws Exception {
        bookDao.saveOrUpdateBooks(book);
        assertThat(bookDao.getAllBooks().size(), is(equalTo(1)));
    }

    public void testGetAllBooks() throws Exception {
        assertThat(bookDao.getAllBooks().size(), is(equalTo(0)));
        bookDao.saveOrUpdateBooks(book);
        assertThat(bookDao.getAllBooks().size(), is(equalTo(1)));
    }

    public void testGetAllBooksForUser() throws Exception {
        Book book2 = new Book();
        book2.setItemId(222); book2.setUserEmail("email2"); book2.setTitle("title2");
        bookDao.saveOrUpdateBooks(book);
        bookDao.saveOrUpdateBooks(book2);
        assertThat(bookDao.getAllBooks().size(), is(equalTo(2)));
        assertThat(bookDao.getAllBooksForUser("email").size(), is(equalTo(1)));
    }

    public void testGetBook() throws Exception {
        bookDao.saveOrUpdateBooks(book);
        Book bookResult = bookDao.getBook(111, "email");
        assertThat(book, is(equalTo(bookResult)));
    }

    public void testDeleteBook() throws Exception {
        bookDao.saveOrUpdateBooks(book);
        assertThat(bookDao.getAllBooks().size(), is(equalTo(1)));
        Book bookDeleted = bookDao.deleteBook(111,"email");
        assertThat(bookDao.getAllBooks().size(), is(equalTo(0)));
        assertThat(bookDeleted, is(equalTo(book)));
    }
}