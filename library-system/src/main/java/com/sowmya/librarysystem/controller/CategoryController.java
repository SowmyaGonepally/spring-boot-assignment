package com.sowmya.librarysystem.controller;

import com.sowmya.librarysystem.entity.Category;
import com.sowmya.librarysystem.service.BookService;
import com.sowmya.librarysystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;



    @GetMapping("/listCategories")
    public String listCategories(Model model)
    {
        List<Category> categories=categoryService.findAll();
        model.addAttribute("categories",categories);
        return "list-categories";
    }

    @GetMapping("/addCategoryForm")
    public String addCategoryForm(Model model)
    {
        Category category=new Category();
        model.addAttribute("category",category);
        return "add-category-form";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "add-category-form";
        }
        List<Category> categories=categoryService.findAll();
        for (Category tempCategory: categories) {
            if (tempCategory.getName().equals(category.getName()))
            {
                return "error-already-added";
            }
        }
        categoryService.save(category);

        return "redirect:/listCategories";
    }

    @GetMapping("/showFormForUpdateCategory")
    public String showFormForUpdateCategory(@RequestParam("categoryId") int id, Model model)
    {
        Category category=categoryService.findById(id);
        model.addAttribute("category",category);
        return "add-category-form";
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam("categoryId") int id)
    {
        categoryService.deleteById(id);
        return "redirect:/listCategories";
    }
}
