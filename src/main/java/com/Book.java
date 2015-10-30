package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nicholas on 10/27/2015.
 */
@Entity
@Table(name = "Book")
@XmlRootElement
public class Book implements Serializable {
    @Id
    @Column(name = "itemId")
    private int itemId;
    @Id
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "edition")
    private int edition;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "format")
    private Format format;
    @Column(name = "isRead")
    private Boolean isRead;
    @Column(name = "isReading")
    private Boolean isReading;

    public Book(){
    }

    public Book(String title, String author, Format format, Boolean isReading) {
        this.title = title;
        this.author = author;
        this.format = format;
        this.isReading = isReading;
    }

    public int getItemId(){
        return itemId;
    }

    public void setItemId(int itemId){
        this.itemId = itemId;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public void setUserEmail(String userEmail){
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

    public String getPublisher(){
        return publisher;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public int getEdition(){
        return edition;
    }

    public void setEdition(int edition){
        this.edition = edition;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Boolean getIsRead(){
        return isRead;
    }

    public void setIsRead(Boolean isRead){
        this.isRead = isRead;
    }

    public Boolean getIsReading() {
        return isReading;
    }

    public void setIsReading(Boolean isReading) {
        this.isReading = isReading;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        if(itemId != book.itemId)
            return false;
        if(!(userEmail == null && book.userEmail == null)) {
            if (userEmail.compareTo(book.userEmail) != 0)
                return false;
        }
        if(!(title == null && book.title == null)){
            if(title.compareTo(book.title) != 0)
                return false;
        }
        if(!(author == null && book.author == null)){
            if(author.compareTo(book.author) != 0)
                return false;
        }
        if(!(publisher == null && book.publisher == null)){
            if(publisher.compareTo(book.publisher) != 0)
                return false;
        }
        if(edition != book.edition)
            return false;
        if(isbn != book.isbn)
            return false;
        if(format != book.format)
            return false;
        if(isRead != book.isRead)
            return false;
        if(isReading != book.isReading)
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        int hash;
        final int prime = 31;
        hash = itemId;
        hash = hash * prime + (userEmail != null ? userEmail.hashCode() : 0);
        hash = hash * prime + (title != null ? title.hashCode() : 0);
        hash = hash * prime + (author != null ? author.hashCode() : 0);
        hash = hash * prime + (publisher != null ? publisher.hashCode() : 0);
        hash = hash * prime + edition;
        hash = hash * prime + (isbn != null ? isbn.hashCode() : 0);
        hash = hash * prime + (format != null ? format.hashCode() : 0);
        hash = hash * prime + (isRead != null ? isRead.hashCode() : 0);
        hash = hash * prime + (isReading != null ? isReading.hashCode() : 0);
        return hash;
    }
}