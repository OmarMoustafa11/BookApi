package com.JiveTurkey.JiveTurkeyProject.controller;

import com.JiveTurkey.JiveTurkeyProject.domain.Book;
import com.JiveTurkey.JiveTurkeyProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BookControllers {
    @Autowired

    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books/{categoryId}/books")            //Valid
    public void createBook(@PathVariable(value = "categoryId") Long categoryId, @Valid @RequestBody Book book) {
        bookService.createBook(book,categoryId);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<?>  getBookId(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/books/{categoryId}/books")
    public void updateBook(@RequestBody Book book, @PathVariable (value = "categoryId") Long categoryId) {
        bookService.updateBook(book,categoryId);
    }
    @DeleteMapping("/books/{Id}")
    public void deleteBook(@PathVariable Long Id) {
        bookService.deleteBook(Id);
    }

    @GetMapping("/books/{categoryId}/books")
    public Iterable<Book> findCategoryById(@PathVariable Long categoryId){
        return bookService.findCategoryById(categoryId);
    }


    @GetMapping("/searchbooks")
    public Iterable<Book> searchBooks(@RequestParam("query") String query){
        return bookService.searchBooks(query);
    }

}
