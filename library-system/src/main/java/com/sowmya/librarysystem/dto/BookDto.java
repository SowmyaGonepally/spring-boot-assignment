package com.sowmya.librarysystem.dto;

import com.sowmya.librarysystem.entity.Category;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
public class BookDto {


    private int id;

    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    private String name;

    @NotNull(message = "is required")
    @Size(min=2,message = "please specify at least two characters")
    private String author;

    @Min(value = 1,message = "a minimum of 1 quantity is required")
    @Column(name = "quantity")
    private int quantity;

    private Category category;

    public BookDto() {
    }

    public BookDto(String name, String author, int quantity, Category category) {
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.category = category;
    }


}
