package com.arafa.books.controller;
import com.arafa.books.model.Author;
import com.arafa.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/authors")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/createAuthor")
    public Author createAuthor(@RequestBody Author author){
        return authorService.createAuthor(author);
    }

    @PostMapping("/createAuthors")
    public List<Author> createAuthors(@RequestBody List<Author> Author){
        return authorService.createAuthors(Author);
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("{id}")
    public Author getAuthor(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @DeleteMapping("{id}")
    public String deleteAuthor(@PathVariable Long id){
        return authorService.deleteAuthor(id);
    }

    @PutMapping("{id}")
    public Author updateAuthor(@PathVariable(value="id") Long id,@Valid @RequestBody Author author) {
        return authorService.updateAuthor(author,id);
    }

}