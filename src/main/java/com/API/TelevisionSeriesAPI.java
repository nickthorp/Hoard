package com.API;

import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;

/**
 * Created by Nicholas on 12/7/2015.
 */
@Path("tv")
public class TelevisionSeriesAPI extends ItemAPI {

    private static final String TABLE_NAME = "TelevisionSeries";

    public TelevisionSeriesAPI(){
        ITEM_LINK = "tv";
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllTelevisionSeries() throws Exception {
        deleteAllItems(TABLE_NAME);
    }

    @DELETE
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public void deleteTelevisionSeries(@PathParam("itemId") int itemId,
                            @PathParam("userEmail") String userEmail) throws Exception {
        deleteItem(TABLE_NAME, itemId, userEmail);
    }

    @GET
    @JSONP(queryParam = "callback")
    public String getAllTelevisionSeries(@QueryParam("callback") String callback) throws Exception {
        return getAllItems(TABLE_NAME, callback);
    }

    @GET
    @Path("/{userEmail}")
    @JSONP(queryParam = "callback")
    public String getAllTelevisionSeriesForUser(@QueryParam("userEmail") String userEmail,
                                      @QueryParam("callback") String callback) throws Exception {
        return getAllItemsForUser(TABLE_NAME, userEmail, callback);
    }

    @GET
    @Path("/{userEmail}/{itemId}")
    @JSONP(queryParam = "callback")
    public String getTelevisionSeries(@PathParam("itemId") int itemId,
                           @PathParam("userEmail") String userEmail) throws Exception {
        return getItem(TABLE_NAME, itemId, userEmail);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void saveOrUpdateTelevisionSeries(String itemJson) throws Exception {
        saveOrUpdateItem(itemJson);
    }
}
