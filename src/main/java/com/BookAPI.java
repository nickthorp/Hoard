package com;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Nicholas on 10/31/2015.
 */
@Path("v1/items")
@Produces(MediaType.APPLICATION_JSON)
public class BookAPI {

    private static final String ITEMS_URL = "/TheArchive/v1/items";

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllBooks() throws Exception {
        BookDAO.getInstance().deleteAllBooks();
    }

    @DELETE
    @Path("/{itemId}{userEmail}")
    @JSONP(queryParam = "callback")
    public void deleteBook(@PathParam("itemId") int itemId,
                           @PathParam("userEmail") String userEmail) throws Exception {
        BookDAO.getInstance().deleteBook(itemId, userEmail);
    }

    @GET
    @JSONP(queryParam = "callback")
    public String getAllBooks(@QueryParam("callback") String callback) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        List<Book> books = BookDAO.getInstance().getAllBooks();
        for (Book book : books)
            book.setLink(ITEMS_URL + "/" + book.getItemId());
        return objectMapper.writeValueAsString(books);
    }

    @GET
    @JSONP(queryParam = "callback")
    public String getAllBooksForUser(@QueryParam("userEmail") String userEmail,
                                     @QueryParam("callback") String callback) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        List<Book> books = BookDAO.getInstance().getAllBooksForUser(userEmail);
        for (Book book :books)
            book.setLink(ITEMS_URL + "/" + book.getItemId());
        return objectMapper.writeValueAsString(books);
    }

    @GET
    @Path("/{itemId}{userEmail}")
    @JSONP(queryParam = "callback")
    public String getBook(@PathParam("itemId") int itemId,
                          @PathParam("userEmail") String userEmail) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        Book book = BookDAO.getInstance().getBook(itemId, userEmail);
        return objectMapper.writeValueAsString(book);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void saveOrUpdateBook(String bookJson) throws Exception {
        Book book = new ObjectMapper().readValue(bookJson, Book.class);
        BookDAO.getInstance().saveOrUpdateBooks(book);
    }
}
