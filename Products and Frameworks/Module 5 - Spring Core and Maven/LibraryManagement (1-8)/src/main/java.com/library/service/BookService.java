package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {

    }

    // Constructor Injection
    @Autowired
    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {

        this.bookRepository = bookRepository;

    }

    public void issueBook() {

        System.out.println("Book Service : Issuing Book");

        bookRepository.displayRepository();

    }

}