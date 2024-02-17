package com.example.restapi.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/books"})
public class Controller {

    @Autowired
    private ApiRepository repository;

    @GetMapping()
    public List<Book> getBooks(@RequestParam(name = "title", required = false) String title) {
        if (title != null && !title.isEmpty()) {
            return repository.findByTitle(title);
        } else {
            return repository.findAll();
        }
    }

    @GetMapping({"/{id}"})
    public Optional<Book> getId(@PathVariable Long id) {
        return this.repository.findById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return (Book)this.repository.save(book);
    }
}