package com.subal.FirstWebProject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long publisherID;


    private String publisherName;
    private String city;
    private String state;

    @OneToMany(orphanRemoval = true,cascade = {CascadeType.ALL})
    @JoinColumn(name="publisher_id")
    private Set<Book> books = new HashSet<Book>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Publisher() {
    }

    public Publisher(String publisherName, String city, String state) {
        this.publisherName = publisherName;
        this.city = city;
        this.state = state;
    }

    public long getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(long publisherID) {
        this.publisherID = publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
        Publisher publisher = (Publisher) o;
        return publisherID == publisher.publisherID &&
                publisherName.equals(publisher.publisherName) &&
                city.equals(publisher.city) &&
                state.equals(publisher.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherID, publisherName, city, state);
    }
}
