package com.graded.assignment.controller;


import com.graded.assignment.model.Book;
import com.graded.assignment.service.AuthorService;
import com.graded.assignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import java.util.Optional;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
  
    @Autowired
    private AuthorService authorService;

    // READ - Display list of books
    @GetMapping("/books")
public String viewBooks(Model model) {
    List<Book> books = bookService.getBooksWithAuthors();
    model.addAttribute("books", books);  //
    return "books";
}

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    // CREATE - Show form to add a new book
    @GetMapping("/books/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "create_book";  // Resolves to create_book.jsp
    }

    // Process the creation form submission
    @PostMapping("/books")
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("authors", authorService.getAllAuthors());
            return "create_book";
        }
        try {
            bookService.saveBook(book);
        } catch(Exception e) {
            model.addAttribute("errorMsg", "Error saving the book. Please check the details.");
            return "create_book";
        }
        return "redirect:/books";
    }

    // UPDATE - Show form to edit an existing book
    @GetMapping("/books/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Optional<Book> bookOpt = bookService.getBookById(id);
        if(bookOpt.isPresent()){
            model.addAttribute("book", bookOpt.get());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "update_book";
        }
        return "redirect:/books";
    }

    // Process the update form submission
    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") @Valid Book book,
                             BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("authors", authorService.getAllAuthors());
            return "update_book";
        }
        try {
            book.setId(id);
            bookService.saveBook(book);
        } catch(Exception e) {
            model.addAttribute("errorMsg", "Error updating the book. Please try again.");
            return "update_book";
        }
        return "redirect:/books";
    }
}