package com.JiveTurkey.JiveTurkeyProject.service;

import com.JiveTurkey.JiveTurkeyProject.Repository.BookRepository;
import com.JiveTurkey.JiveTurkeyProject.Repository.CategoryRepository;
import com.JiveTurkey.JiveTurkeyProject.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public ResponseEntity<Iterable<Book>> getAllBooks() {
        Iterable<Book> allBooks = bookRepository.findAll();
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    public void createBook(Book book, Long categoryId) {
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);

        });


    }

    public ResponseEntity<?> getBookById(Long bookId) {
        Optional<Book> b = bookRepository.findById(bookId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }


    public void updateBook(Book book, Long categoryId) {
        categoryRepository.findById(categoryId).map(category -> {
            book.setCategory(category);
            return bookRepository.save(book);
        });

    }


    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public Iterable<Book> findCategoryById(Long categoryId){
        return bookRepository.findByCategoryId(categoryId);
    }

    public Iterable<Book> searchBooks(String query){
        return bookRepository.searchBooks(query);
    }


}
