package com.sowmya.librarysystem.dao;

import com.sowmya.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
}
