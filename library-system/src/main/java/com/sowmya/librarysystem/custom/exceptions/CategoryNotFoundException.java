package com.sowmya.librarysystem.custom.exceptions;

public class CategoryNotFoundException extends RuntimeException{

    public  CategoryNotFoundException(String message) {
        super(message);
    }
}
