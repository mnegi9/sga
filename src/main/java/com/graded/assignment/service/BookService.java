package com.graded.assignment.service;

import com.graded.assignment.model.Book;
import com.graded.assignment.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksWithAuthors() {
        return bookRepository.findBooksWithAuthors();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}