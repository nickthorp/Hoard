package com.API;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Nicholas on 12/5/2015.
 */
@Path("comics")
@Produces(MediaType.APPLICATION_JSON)
public class ComicAPI extends ItemAPI {

    private static final String TABLE_NAME = "Comic";

    public ComicAPI(){
        ITEM_LINK = "comics";
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllComics() throws Exception {
        deleteAllItems(TABLE_NAME);
    }

    @DELETE
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public void deleteComic(@PathParam("itemId") int itemId,
                           @PathParam("userEmail") String userEmail) throws Exception {
        deleteItem(TABLE_NAME, itemId, userEmail);
    }

    @GET
    @JSONP(queryParam = "callback")
    public String getAllComics(@QueryParam("callback") String callback) throws Exception {
        return getAllItems(TABLE_NAME, callback);
    }

    @GET
    @Path("/{userEmail}")
    @JSONP(queryParam = "callback")
    public String getAllComicsForUser(@QueryParam("userEmail") String userEmail,
                                     @QueryParam("callback") String callback) throws Exception {
        return getAllItemsForUser(TABLE_NAME, userEmail, callback);
    }

    @GET
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public String getComic(@PathParam("itemId") int itemId,
                          @PathParam("userEmail") String userEmail) throws Exception {
        return getItem(TABLE_NAME, itemId, userEmail);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void saveOrUpdateComic(String itemJson) throws Exception {
        saveOrUpdateItem(itemJson);
    }
}
