package com.sowmya.librarysystem.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "is required")
    @Size(min = 2,message = "please specify at least two characters")
    @Column(name = "name")
    private String Name;

    //if a category is deleted, all the corresponding books must be deleted
    //mapped by=category. category refers to the property in Book class
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Book> books;


    public Category() {
    }

    public Category(String name) {
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
