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
    private String Name;

    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    @Column(name = "author")
    private String Author;

    @NotNull(message = "is required")
    @Min(value = 1,message = "a minimum of 1 quantity is required")
    @Column(name = "quantity")
    private int Quantity;


    //many books can belong to one category
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
    }

    public Book(String name, String author, int quantity, Category category) {
        Name = name;
        Author = author;
        Quantity = quantity;
        this.category = category;
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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
