package com.API;

import com.DataAccessObjects.ItemDAO;
import com.DataObjects.Item;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Nicholas on 12/5/2015.
 */
@Path("items")
@Produces(MediaType.APPLICATION_JSON)
public abstract class ItemAPI {

    private static final String ITEM_BASE_URL = "/TheArchive/";
    public static String ITEM_LINK;

    public void deleteAllItems(String table) throws Exception {
        ItemDAO.getInstance().deleteAllItems(table);
    }

    public void deleteItem(String table, int itemId, String userEmail) {
        ItemDAO.getInstance().deleteItem(table, itemId, userEmail);
    }

    public String getAllItems(String table, String callback) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        List<Item> items = ItemDAO.getInstance().getAllItems(table);
        for (Item item : items)
            item.setLink(ITEM_BASE_URL + ITEM_LINK + "/" + item.getUserEmail() + "/" + item.getItemId());
        return objectMapper.writeValueAsString(items);
    }

    public String getAllItemsForUser(String table, String userEmail, String callback) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        List<Item> items = ItemDAO.getInstance().getAllItemsForUser(table, userEmail);
        for (Item item : items)
            item.setLink(ITEM_BASE_URL + ITEM_LINK + "/" + item.getUserEmail() + "/" + item.getItemId());
        return objectMapper.writeValueAsString(items);
    }

    public String getItem(String table, int itemId, String userEmail) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        Item item = ItemDAO.getInstance().getItem(table, itemId, userEmail);
        item.setLink(ITEM_BASE_URL + ITEM_LINK + "/" + item.getUserEmail() + "/" + item.getItemId());
        return objectMapper.writeValueAsString(item);
    }

    public void saveOrUpdateItem(String itemJson) throws Exception {
        Item item = new ObjectMapper().readValue(itemJson, Item.class);
        ItemDAO.getInstance().saveOrUpdateItems(item);
    }
}
