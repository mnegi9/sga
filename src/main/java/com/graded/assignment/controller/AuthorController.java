package com.graded.assignment.controller;

import com.graded.assignment.service.AuthorService;
import com.graded.assignment.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "create_author"; // This should match the JSP filename
    }

    @PostMapping("/authors")
    public String addAuthor(@ModelAttribute("author") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/books"; // Redirect after creation
    }
}
