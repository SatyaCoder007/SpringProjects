package com.subal.FirstWebProject.model;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorID;

   private String authorName;
   private String authorCity;
   private String state;

   @ManyToMany(mappedBy = "authors")
   private Set<Book> books = new HashSet<Book>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Author() {
    }

    public Author(String authorName, String authorCity, String state) {
        this.authorName = authorName;
        this.authorCity = authorCity;
        this.state = state;
    }

    public long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorCity() {
        return authorCity;
    }

    public void setAuthorCity(String authorCity) {
        this.authorCity = authorCity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorID == author.authorID &&
                authorName.equals(author.authorName) &&
                authorCity.equals(author.authorCity) &&
                state.equals(author.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorID, authorName, authorCity, state);
    }
}
