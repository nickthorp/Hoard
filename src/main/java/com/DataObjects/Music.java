package com.DataObjects;


import com.FormatEnums.AudioFormat;

/**
 * Created by Nicholas on 11/23/2015.
 */
public class Music {

    private int itemId;
    private String userEmail;
    private String artistName;
    private String albumTitle;
    //private ArrayList<String> songTitles;
    //private Image albumArt;
    private AudioFormat format;
    private Boolean isListening;
    private String link;

    public Music(){}

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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public Boolean getListening() {
        return isListening;
    }

    public void setListening(Boolean listening) {
        isListening = listening;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public AudioFormat getFormat() {
        return format;
    }

    public void setFormat(AudioFormat format) {
        this.format = format;
    }
}
