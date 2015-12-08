package com.API;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Nicholas on 12/7/2015.
 */
@Path("tabletop")
@Produces(MediaType.APPLICATION_JSON)
public class TabletopGameAPI extends ItemAPI {

    private static final String TABLE_NAME = "TabletopGame";

    public TabletopGameAPI(){
        ITEM_LINK = "tabletop";
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllTabletopGames() throws Exception {
        deleteAllItems(TABLE_NAME);
    }

    @DELETE
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public void deleteTabletopGame(@PathParam("itemId") int itemId,
                            @PathParam("userEmail") String userEmail) throws Exception {
        deleteItem(TABLE_NAME, itemId, userEmail);
    }

    @GET
    @JSONP(queryParam = "callback")
    public String getAllTabletopGames(@QueryParam("callback") String callback) throws Exception {
        return getAllItems(TABLE_NAME, callback);
    }

    @GET
    @Path("/{userEmail}")
    @JSONP(queryParam = "callback")
    public String getAllTabletopGamesForUser(@QueryParam("userEmail") String userEmail,
                                      @QueryParam("callback") String callback) throws Exception {
        return getAllItemsForUser(TABLE_NAME, userEmail, callback);
    }

    @GET
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public String getTabletopGame(@PathParam("itemId") int itemId,
                           @PathParam("userEmail") String userEmail) throws Exception {
        return getItem(TABLE_NAME, itemId, userEmail);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void saveOrUpdateTabletopGame(String itemJson) throws Exception {
        saveOrUpdateItem(itemJson);
    }
}