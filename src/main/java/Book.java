/**
 * Created by Nicholas on 10/27/2015.
 */
public class Book {
    private String title;
    private String author;
    private Format format;
    private Boolean isReading;

    public Book(){
    }

    public Book(String title, String author, Format format, Boolean isReading) {
        this.title = title;
        this.author = author;
        this.format = format;
        this.isReading = isReading;
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

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Boolean getIsReading() {
        return isReading;
    }

    public void setIsReading(Boolean isReading) {
        this.isReading = isReading;
    }

    @Override
    public boolean equals(Object o){
        Book book = (Book) o;
        if(this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if(title.compareTo(book.title) != 0)
            return false;
        if(author.compareTo(book.author) != 0)
            return false;
        if (isReading != book.isReading)
            return false;
        if(format != book.format)
            return false;
        return true;
    }
}
