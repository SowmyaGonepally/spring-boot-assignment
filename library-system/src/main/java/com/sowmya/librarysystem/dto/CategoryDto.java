package com.sowmya.librarysystem.dto;

import com.sowmya.librarysystem.entity.Book;
import lombok.Data;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
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

}
