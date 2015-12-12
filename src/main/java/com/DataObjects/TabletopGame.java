package com.DataObjects;

import com.FormatEnums.TableTopFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nicholas on 11/23/2015.
 */
@Entity
@Table(name ="TabletopGame")
@XmlRootElement
public class TabletopGame implements Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemId")
    private int itemId;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "title")
    private String title;
    @Column(name = "minPlayers")
    private int minPlayers;
    @Column(name = "maxPlayers")
    private int maxPlayers;
    @Column(name = "format")
    private TableTopFormat format;
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
        return format;
    }

    public void setFormat(TableTopFormat format) {
        this.format = format;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
