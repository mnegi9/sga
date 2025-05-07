package com.graded.assignment.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    // Constructors
    public Author() { }

    public Author(String name, String country) {
        this.name = name;
        this.country = country;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
  
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
  
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
  
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }
}