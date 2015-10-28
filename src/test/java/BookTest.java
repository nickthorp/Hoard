import junit.framework.TestCase;

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
        Format expected = Format.HARDCOVER;
        Book book = new Book();
        book.setFormat(Format.HARDCOVER);
        assertEquals(expected, book.getFormat());
    }

    public void testIsReadingHasGetterAndSetter() throws Exception {
        Boolean expected = true;
        Book book = new Book();
        book.setIsReading(expected);
        assertEquals(book.getIsReading(), expected);
    }

    public void testEquals() throws Exception {

    }
}