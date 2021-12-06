package com.sowmya.librarysystem.service;

import com.sowmya.librarysystem.entity.Book;

import java.util.List;

public interface BookService {

     List<Book> findAll();

     Book findById(int id);

     void save(Book book);

     void deleteById(int id);

     List<Book> findBookByCategory(int categoryId);

}
