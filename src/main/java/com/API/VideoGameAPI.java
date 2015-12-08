package com.API;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;

/**
 * Created by Nicholas on 12/7/2015.
 */
@Path("videogames")
public class VideoGameAPI extends ItemAPI {

    private static final String TABLE_NAME = "VideoGame";

    public VideoGameAPI(){
        ITEM_LINK = "videogames";
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllVideoGames() throws Exception {
        deleteAllItems(TABLE_NAME);
    }

    @DELETE
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public void deleteVideoGame(@PathParam("itemId") int itemId,
                            @PathParam("userEmail") String userEmail) throws Exception {
        deleteItem(TABLE_NAME, itemId, userEmail);
    }

    @GET
    @JSONP(queryParam = "callback")
    public String getAllVideoGames(@QueryParam("callback") String callback) throws Exception {
        return getAllItems(TABLE_NAME, callback);
    }

    @GET
    @Path("/{userEmail}")
    @JSONP(queryParam = "callback")
    public String getAllVideoGamesForUser(@QueryParam("userEmail") String userEmail,
                                      @QueryParam("callback") String callback) throws Exception {
        return getAllItemsForUser(TABLE_NAME, userEmail, callback);
    }

    @GET
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public String getVideoGame(@PathParam("itemId") int itemId,
                           @PathParam("userEmail") String userEmail) throws Exception {
        return getItem(TABLE_NAME, itemId, userEmail);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void saveOrUpdateVideoGame(String itemJson) throws Exception {
        saveOrUpdateItem(itemJson);
    }
}
