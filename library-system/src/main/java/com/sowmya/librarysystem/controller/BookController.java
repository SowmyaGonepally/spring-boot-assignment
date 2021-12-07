package com.sowmya.librarysystem.controller;

import com.sowmya.librarysystem.dto.BookDto;
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
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    private static final String ADD_BOOK_FORM ="add-book-form";
    private static final String CATEGORIES_ATTRIBUTE ="categories";


    @GetMapping("/listBooks")
    public String listBooks(@RequestParam("categoryId") Optional<Integer> categoryId, Model model){
        List<Book> books;
        if(categoryId.isEmpty())
        {
             books=bookService.findAll();
        }
        else
        {
             books=bookService.findBookByCategory(categoryId.get().intValue());
        }
        model.addAttribute("books",books);
        List<Category> categories=categoryService.findAll();
        model.addAttribute(CATEGORIES_ATTRIBUTE,categories);
        return "list-books";
    }

    @GetMapping("/addBookForm")
    public String addBook(Model model)
    {
        BookDto bookDto=new BookDto();
        model.addAttribute("book",bookDto);

        List<Category> categories=categoryService.findAll();
        model.addAttribute(CATEGORIES_ATTRIBUTE,categories);
        return ADD_BOOK_FORM;
    }

    @PostMapping("/saveBook")
    public String saveBook(@Valid @ModelAttribute("book") BookDto bookDto, BindingResult bindingResult,Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("book",bookDto);
            List<Category> categories=categoryService.findAll();
            model.addAttribute(CATEGORIES_ATTRIBUTE,categories);
            return ADD_BOOK_FORM;
        }
        Book book=new Book(bookDto.getName(),bookDto.getAuthor(),bookDto.getQuantity(),bookDto.getCategory());
        book.setId(bookDto.getId());
        bookService.save(book);

        return "redirect:/listBooks";
    }

    @GetMapping("showFormForUpdateBook")
    public String showFormForUpdateBook(@RequestParam("bookId") int id, Model model)
    {
        Book book=bookService.findById(id);
        model.addAttribute("book",book);
        List<Category> categories=categoryService.findAll();
        model.addAttribute(CATEGORIES_ATTRIBUTE,categories);

        return ADD_BOOK_FORM;
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int id)
    {
        bookService.deleteById(id);
        return "redirect:/listBooks";
    }

}
