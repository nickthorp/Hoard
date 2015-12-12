package com.DataObjects;


import com.FormatEnums.AudioFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nicholas on 11/23/2015.
 */
@Entity
@Table(name = "Music")
@XmlRootElement
public class Music implements Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private int itemId;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "artistName")
    private String artistName;
    @Column(name = "albumTitle")
    private String albumTitle;
    //private ArrayList<String> songTitles;
    //private Image albumArt;
    @Column(name = "format")
    private AudioFormat format;
    @Column(name = "isListening")
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
