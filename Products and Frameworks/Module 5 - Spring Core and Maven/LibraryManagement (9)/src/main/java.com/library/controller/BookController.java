package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    // Create
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repository.save(book);
    }

    // Read All
    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    // Read by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // Update
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {

        Book book = repository.findById(id).orElse(null);

        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return repository.save(book);
        }

        return null;
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        repository.deleteById(id);

        return "Book Deleted Successfully";
    }
}