package com.DataObjects;

import com.FormatEnums.VideoGameFormat;

/**
 * Created by Nicholas on 11/23/2015.
 */
public class VideoGame {

    private int itemId;
    private String userEmail;
    private String title;
    private VideoGameFormat format;
    private Boolean isPlayed;
    private Boolean isPlaying;
    private String developer;
    private String link;

    public VideoGame(){}

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

    public VideoGameFormat getFormat() {
        return format;
    }

    public void setFormat(VideoGameFormat format) {
        this.format = format;
    }

    public Boolean getPlayed() {
        return isPlayed;
    }

    public void setPlayed(Boolean played) {
        isPlayed = played;
    }

    public Boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(Boolean playing) {
        isPlaying = playing;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
