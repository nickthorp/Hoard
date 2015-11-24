package com;

import com.DataObjects.Book;
import com.FormatEnums.PrintFormat;
import junit.framework.TestCase;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Nicholas on 10/27/2015.
 */
public class BookTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testItemIdHasGetterAndSetter() throws Exception {
        int expected = 111;
        Book book = new Book();
        book.setItemId(expected);
        assertThat(book.getItemId(), is(equalTo(expected)));
    }

    public void testTitleHasGetterAndSetter() throws Exception {
        String expected = "Hello World";
        Book book = new Book();
        book.setTitle(expected);
        assertEquals(book.getTitle(), expected);
    }

    public void testAuthorHasGetterAndSetter() throws Exception {
        String expected = "Person";
        Book book = new Book();
        book.setAuthor(expected);
        assertEquals(book.getAuthor(), expected);
    }

    public void testFormatHasGetterAndSetter() throws Exception {
        PrintFormat expected = PrintFormat.HARDCOVER;
        Book book = new Book();
        book.setFormat(PrintFormat.HARDCOVER);
        assertEquals(expected, book.getFormat());
    }

    public void testIsReadingHasGetterAndSetter() throws Exception {
        Boolean expected = true;
        Book book = new Book();
        book.setIsReading(expected);
        assertEquals(book.getIsReading(), expected);
    }

    /**
     * The following tests confirm the functionality of equals() and hashCode()
     * overridden methods.
     * @throws Exception
     */
    public void testEqualsAndHashCode() throws Exception {
        Book book = new Book();
        book.setItemId(111);
        book.setUserEmail("userEmail");
        book.setTitle("title");
        book.setAuthor("author");
        book.setPublisher("publisher");
        //book.setEdition(1);
        book.setIsbn("123451234141");
        book.setFormat(PrintFormat.HARDCOVER);
        book.setIsRead(false);
        book.setIsReading(true);
        Book bookExpected = new Book();
        bookExpected.setItemId(111);
        bookExpected.setUserEmail("userEmail");
        bookExpected.setTitle("expected title");
        bookExpected.setAuthor("author");
        bookExpected.setPublisher("publisher");
        //bookExpected.setEdition(1);
        bookExpected.setIsbn("123451234141");
        bookExpected.setFormat(PrintFormat.HARDCOVER);
        bookExpected.setIsRead(false);
        bookExpected.setIsReading(true);
        assertThat(book, is(not(equalTo(bookExpected))));
    }
}