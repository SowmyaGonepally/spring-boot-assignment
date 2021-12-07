package com.sowmya.librarysystem.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    @Column(name = "author")
    private String author;

    @NotNull(message = "is required")
    @Min(value = 1,message = "a minimum of 1 quantity is required")
    @Column(name = "quantity")
    private int quantity;


    //many books can belong to one category
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
    }

    public Book(String name, String author, int quantity, Category category) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
