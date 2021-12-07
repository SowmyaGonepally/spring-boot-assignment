package com.sowmya.librarysystem.dto;

import com.sowmya.librarysystem.entity.Book;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CategoryDto {


    private int id;

    @NotNull(message = "is required")
    @Size(min = 2,message = "please specify at least two characters")
    private String name;

    private List<Book> books;


    public CategoryDto() {
    }

    public CategoryDto(String name) {
        this.name = name;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
