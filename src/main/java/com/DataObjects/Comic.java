package com.DataObjects;

import com.FormatEnums.PrintFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nicholas on 11/19/2015.
 */
@Entity
@Table(name = "Comic")
@XmlRootElement
public class Comic implements Serializable, Item {
    @Id
    @Column(name = "itemId")
    private int itemId;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "artist")
    private String artist;
    @Column(name = "volume")
    private String volume;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "format")
    private PrintFormat format;
    @Column(name = "isRead")
    private Boolean isRead;
    @Column(name = "isReading")
    private Boolean isReading;
    private String link;

    public Comic (){}

    public Comic (int itemId, String userEmail, String title, String author, String artist,
                  String volume, String publisher, PrintFormat format, Boolean isRead, Boolean isReading){
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

    public PrintFormat getFormat() {
        return format;
    }

    public void setFormat(PrintFormat format) {
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
