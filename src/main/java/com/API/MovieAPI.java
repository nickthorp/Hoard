package com.API;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Nicholas on 12/7/2015.
 */
@Path("movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieAPI extends ItemAPI {

    private static final String TABLE_NAME = "Movie";

    public MovieAPI(){
        ITEM_LINK = "movies";
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllMovies() throws Exception {
        deleteAllItems(TABLE_NAME);
    }

    @DELETE
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public void deleteMovie(@PathParam("itemId") int itemId,
                            @PathParam("userEmail") String userEmail) throws Exception {
        deleteItem(TABLE_NAME, itemId, userEmail);
    }

    @GET
    @JSONP(queryParam = "callback")
    public String getAllMovies(@QueryParam("callback") String callback) throws Exception {
        return getAllItems(TABLE_NAME, callback);
    }

    @GET
    @Path("/{userEmail}")
    @JSONP(queryParam = "callback")
    public String getAllMoviesForUser(@QueryParam("userEmail") String userEmail,
                                      @QueryParam("callback") String callback) throws Exception {
        return getAllItemsForUser(TABLE_NAME, userEmail, callback);
    }

    @GET
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public String getMovie(@PathParam("itemId") int itemId,
                           @PathParam("userEmail") String userEmail) throws Exception {
        return getItem(TABLE_NAME, itemId, userEmail);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void saveOrUpdateMovie(String itemJson) throws Exception {
        saveOrUpdateItem(itemJson);
    }
}
