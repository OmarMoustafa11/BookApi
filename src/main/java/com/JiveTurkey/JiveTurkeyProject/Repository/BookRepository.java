package com.JiveTurkey.JiveTurkeyProject.Repository;

import com.JiveTurkey.JiveTurkeyProject.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository <Book,Long> {
    @Query( value = "SELECT b FROM Book b WHERE " + "b.name LIKE CONCAT('%',:query, '%')")
    Iterable<Book> searchBooks(String query);

    Iterable<Book> findByCategoryId(Long categoryId);
}
