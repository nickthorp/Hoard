package com.DataObjects;

import com.FormatEnums.TableTopFormat;

/**
 * Created by Nicholas on 11/23/2015.
 */
public class TabletopGame {

    private int itemId;
    private String userEmail;
    private String title;
    private int minPlayers;
    private int maxPlayers;
    private TableTopFormat Format;
    private String link;

    public TabletopGame(){}

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public TableTopFormat getFormat() {
        return Format;
    }

    public void setFormat(TableTopFormat format) {
        Format = format;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
