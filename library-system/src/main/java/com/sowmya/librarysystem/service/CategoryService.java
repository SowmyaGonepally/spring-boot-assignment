package com.sowmya.librarysystem.service;

import com.sowmya.librarysystem.entity.Category;

import java.util.List;

public interface CategoryService {

     List<Category> findAll();

     Category findById(int id);

     void save(Category category);

     void deleteById(int id);


}
