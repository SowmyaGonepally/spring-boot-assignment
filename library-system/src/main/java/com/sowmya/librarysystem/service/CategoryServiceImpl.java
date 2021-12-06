package com.sowmya.librarysystem.service;

import com.sowmya.librarysystem.customExceptions.CategoryNotFoundEXception;
import com.sowmya.librarysystem.dao.CategoryRepository;
import com.sowmya.librarysystem.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    //inject category repository

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {

        Optional<Category>result=categoryRepository.findById(id);
        Category category;
        if(result.isPresent())
        {
            category=result.get();
        }
        else
        {
            throw new CategoryNotFoundEXception("Did not find the category!");
        }
        return category;
    }

    @Override
    public void save(Category category) {

        categoryRepository.save(category);
    }

    @Override
    public void deleteById(int id) {
       categoryRepository.deleteById(id);
    }
}
