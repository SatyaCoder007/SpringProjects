package com.subal.FirstWebProject.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private  Long bookID;

    private  String bookName;
    private  String ISBN;

    @ManyToMany
    @JoinTable(name="Author_book",joinColumns =@JoinColumn(name="book_id"),inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors = new HashSet<Author>();

    @ManyToOne
    private Publisher publishers;

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublishers() {
        return publishers;
    }

    public void setPublishers(Publisher publishers) {
        this.publishers = publishers;
    }



    public Book() {
    }

    public Book(String bookName, String ISBN) {
        this.bookName = bookName;
        this.ISBN = ISBN;
    }


    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID &&
                bookName.equals(book.bookName) &&
                ISBN.equals(book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID, bookName, ISBN);
    }
}
