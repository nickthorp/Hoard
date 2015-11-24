package com.DataAccessObjects;

import com.DataAccessObjects.ItemDAO;
import com.DataObjects.Book;
import com.DataObjects.Item;
import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Nicholas on 11/24/2015.
 */
public class ItemDAOTest extends TestCase {

    private ItemDAO itemDAO;
    private Book book;

    public void setUp() throws Exception {
        super.setUp();
        book = new Book();
        book.setItemId(111); book.setUserEmail("email"); book.setTitle("title");
        itemDAO = ItemDAO.getInstance();
    }

    public void tearDown() throws Exception {
        itemDAO.deleteAllItems("Book");
    }

    public void testDeleteAllItems() throws Exception {
        itemDAO.deleteAllItems("Book");
        assertThat(itemDAO.getAllItems("Book").size(), is(equalTo(0)));
    }

    public void testSaveOrUpdateItems() throws Exception {
        itemDAO.saveOrUpdateItems(book);
        assertThat(itemDAO.getAllItems("Book").size(), is(equalTo(1)));
    }

    public void testGetAllItems() throws Exception {
        assertThat(itemDAO.getAllItems("Book").size(), is(equalTo(0)));
        itemDAO.saveOrUpdateItems(book);
        assertThat(itemDAO.getAllItems("Book").size(), is(equalTo(1)));
    }

    public void testGetAllItemsForUser() throws Exception {
        Book book2 = new Book();
        book2.setItemId(222); book2.setUserEmail("email2"); book2.setTitle("title2");
        itemDAO.saveOrUpdateItems(book);
        itemDAO.saveOrUpdateItems(book2);
        assertThat(itemDAO.getAllItems("Book").size(), is(equalTo(2)));
        assertThat(itemDAO.getAllItemsForUser("Book", "email").size(), is(equalTo(1)));
    }

    public void testGetItem() throws Exception {
        itemDAO.saveOrUpdateItems(book);
        Item bookResult = itemDAO.getItem("Book", 111, "email");
        assertThat(book, is(equalTo(bookResult)));
    }

    public void testDeleteItem() throws Exception {
        itemDAO.saveOrUpdateItems(book);
        assertThat(itemDAO.getAllItems("Book").size(), is(equalTo(1)));
        Book itemDeleted = (Book) itemDAO.deleteItem("Book", 111,"email");
        assertThat(itemDAO.getAllItems("Book").size(), is(equalTo(0)));
        assertThat(itemDeleted, is(equalTo(book)));
    }
}