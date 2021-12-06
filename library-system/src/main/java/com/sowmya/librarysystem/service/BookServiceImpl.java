package com.sowmya.librarysystem.service;

import com.sowmya.librarysystem.customExceptions.BookNotFoundException;
import com.sowmya.librarysystem.dao.BookRepository;
import com.sowmya.librarysystem.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    //inject BookRepository
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        Optional<Book> result=bookRepository.findById(id);
        Book book;
        if(result.isPresent())
        {
            book=result.get();
        }
        else
        {
            throw new BookNotFoundException("Did not find the book!");
        }
        return book;
    }

    @Override
    public void save(Book book) {
      bookRepository.save(book);
    }

    @Override
    public void deleteById(int id) {
      bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findBookByCategory(int categoryId) {

        List<Book>booksByCategory=new ArrayList<>();
        List<Book>books=bookRepository.findAll();
        for (Book book: books) {

            if(book.getCategory().getId()==categoryId)
            {
                booksByCategory.add(book);
            }

        }
        return booksByCategory;
    }
}
