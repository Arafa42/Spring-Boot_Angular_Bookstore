package com.arafa.books.controller;
import com.arafa.books.model.Book;
import com.arafa.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/createBook")
    public Book createBook(@RequestBody  Book book){return bookService.createBook(book);}

    @PostMapping("/createBooks")
    public List<Book> createBooks(@RequestBody List<Book> books){return bookService.createBooks(books);}

    @GetMapping("{id}")
    public Book getBookById(@PathVariable Long id){return bookService.getBookById(id);}

    @GetMapping()
    public List<Book> getAllBooks(){return bookService.getAllBooks();}

    @DeleteMapping("{id}")
    public String deleteBook(Long id){return bookService.deleteBook(id);}

    @PutMapping("{id}")
    public Book updateBook(@PathVariable Long id,@Valid @RequestBody Book book){return bookService.updateBook(book,id);}
}