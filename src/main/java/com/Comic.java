package com;

import java.io.Serializable;

/**
 * Created by Nicholas on 11/19/2015.
 */
public class Comic implements Serializable {

    private int itemId;
    private String userEmail;
    private String title;
    private String author;
    private String artist;
    private String volume;
    private String publisher;
    private Format format;
    private Boolean isRead;
    private Boolean isReading;
    private String link;

    public Comic (){}

    public Comic (int itemId, String userEmail, String title, String author, String artist,
                  String volume, String publisher, Format format, Boolean isRead, Boolean isReading){
        this.itemId = itemId; this.userEmail = userEmail; this.title = title; this.author = author;
        this.artist = artist; this.publisher = publisher; this.volume = volume; this.format = format;
        this.isRead = isRead; this.isReading = isReading;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public Boolean getReading() {
        return isReading;
    }

    public void setReading(Boolean reading) {
        isReading = reading;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
