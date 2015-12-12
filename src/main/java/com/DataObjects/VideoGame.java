package com.DataObjects;

import com.FormatEnums.VideoGameFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nicholas on 11/23/2015.
 */
@Entity
@Table(name = "VideoGame")
@XmlRootElement
public class VideoGame implements Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private int itemId;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "title")
    private String title;
    @Column(name = "format")
    private VideoGameFormat format;
    @Column(name = "isPlayed")
    private Boolean isPlayed;
    @Column(name = "isPlaying")
    private Boolean isPlaying;
    @Column(name = "isCompleted")
    private Boolean isCompleted;
    @Column(name = "developer")
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

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
