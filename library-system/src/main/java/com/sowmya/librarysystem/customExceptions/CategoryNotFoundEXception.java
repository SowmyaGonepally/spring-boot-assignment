package com.sowmya.librarysystem.customExceptions;

public class CategoryNotFoundEXception extends RuntimeException{
    public CategoryNotFoundEXception() {
        super();
    }

    public CategoryNotFoundEXception(String message) {
        super(message);
    }
}
