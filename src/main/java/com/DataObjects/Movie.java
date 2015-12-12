package com.DataObjects;


import com.FormatEnums.VideoFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nicholas on 11/23/2015.
 */
@Entity
@Table(name = "Movie")
@XmlRootElement
public class Movie implements Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private int itemId;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "title")
    private String title;
    @Column(name = "releaseYear")
    private int releaseYear;
    @Column(name = "director")
    private String director;
    @Column(name = "format")
    private VideoFormat format;
    @Column(name = "isWatched")
    private Boolean isWatched;
    @Column(name = "isWatching")
    private Boolean isWatching;
    private String link;

    public Movie() {}

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

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public VideoFormat getFormat() {
        return format;
    }

    public void setFormat(VideoFormat format) {
        this.format = format;
    }

    public Boolean getWatched() {
        return isWatched;
    }

    public void setWatched(Boolean watched) {
        isWatched = watched;
    }

    public Boolean getWatching() {
        return isWatching;
    }

    public void setWatching(Boolean watching) {
        isWatching = watching;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
