package com.graded.assignment.repository;

import com.graded.assignment.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom query to join books and authors
    @Query("SELECT b FROM Book b JOIN b.author a")
    List<Book> findBooksWithAuthors();
}