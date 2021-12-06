package com.sowmya.librarysystem.controller;

import com.sowmya.librarysystem.entity.Book;
import com.sowmya.librarysystem.entity.Category;
import com.sowmya.librarysystem.service.BookService;
import com.sowmya.librarysystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;



    @GetMapping("/listBooks")
    public String listBooks(@RequestParam("categoryId") Optional<Integer> categoryId, Model model){
        List<Book> books;
        if(!categoryId.isPresent())
        {
             books=bookService.findAll();
        }
        else
        {
             books=bookService.findBookByCategory(categoryId.get().intValue());
        }
        System.out.println(books);
        model.addAttribute("books",books);
        List<Category> categories=categoryService.findAll();
        model.addAttribute("categories",categories);
        return "list-books";
    }

    @GetMapping("/addBookForm")
    public String addBook(Model model)
    {
        Book book=new Book();
        model.addAttribute("book",book);

        List<Category> categories=categoryService.findAll();
        model.addAttribute("categories",categories);
        return "add-book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult,Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("book",book);
            List<Category> categories=categoryService.findAll();
            model.addAttribute("categories",categories);
            return "add-book-form";
        }
        bookService.save(book);

        return "redirect:/listBooks";
    }

    @GetMapping("showFormForUpdateBook")
    public String showFormForUpdateBook(@RequestParam("bookId") int id, Model model)
    {
        Book book=bookService.findById(id);
        model.addAttribute("book",book);
        List<Category> categories=categoryService.findAll();
        model.addAttribute("categories",categories);

        return "add-book-form";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int id)
    {
        bookService.deleteById(id);
        return "redirect:/listBooks";
    }

}
