package com;

import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.*;
import org.skyscreamer.jsonassert.JSONAssert;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Nicholas on 10/31/2015.
 */
public class BookAPITest {

    private static HttpServer theArchiveServer;
    private ObjectMapper objectMapper;
    private WebTarget itemsTarget;
    private ArrayList<Book> bookList;
    private BookDAO bookDao;


    @Before
    public void setUp() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/TheArchive/");
        itemsTarget = webTarget.path("v1/items");
        objectMapper = new ObjectMapper();
        bookList = new ArrayList<>();
        bookDao = BookDAO.getInstance();
        for(int i=1;i<6;i++){
            bookList.add(new Book());
            bookList.get(i-1).setItemId(i);
            if (i<4)
                bookList.get(i-1).setUserEmail("user" + 1 + "@example.com");
            else
                bookList.get(i-1).setUserEmail("user" + 2 + "@example.com");
            bookList.get(i-1).setTitle("book " + i);
            bookDao.saveOrUpdateBooks(bookList.get(i-1));
        }
    }

    @BeforeClass
    public static void beforeTests(){
        theArchiveServer = new TheArchiveServer().startServer();
    }

    @After
    public void tearDown() throws Exception {
        bookDao.deleteAllBooks();
    }

    @AfterClass
    public static void afterTests(){
        theArchiveServer.shutdown();
    }

    @Test
    public void testDeleteAllBooks(){
        assert true;
    }

    @Test
    public void v1ItemsShouldReturnStatus200(){
        assertThat(itemsTarget.request().head().getStatus(), is(200));
    }

    @Test
    public void v1ItemsShouldReturnTypeJson(){
        assertThat(itemsTarget.request().get().getMediaType().toString(), is("application/json"));
    }

    @Test
    public void v1ItemsShouldReturnAListOfBooks() throws Exception {
        int size = bookList.size();
        String json = itemsTarget.request().get(String.class);
        List<Book> actual = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Book.class));
        assertThat(actual.size(), is(size));
    }

    @Test
    public void v1ItemsShouldReturnTheCorrectJson() throws Exception {
        bookList.remove(4); bookList.remove(3);
        bookList.remove(2); bookList.remove(1);
        bookDao.deleteAllBooks();
        bookDao.saveOrUpdateBooks(bookList.get(0));
        String json = itemsTarget.request().get(String.class);
        JSONAssert.assertEquals("[{itemId: 1}]", json, false);
        JSONAssert.assertEquals("[{link: \"/TheArchive/v1/items/1\"}]", json, false);
        JSONAssert.assertEquals("[{userEmail: \"user1@example.com\"}]", json, false);
        JSONAssert.assertEquals("[{title: \"book 1\"}]", json, false);
    }

}