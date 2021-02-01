package com.arafa.books.service;


import com.arafa.books.model.Book;
import com.arafa.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long id){return bookRepository.findById(id).orElse(null);}

    public List<Book> getAllBooks(){return bookRepository.findAll();}

    public Book createBook(Book book){return bookRepository.save(book);}

    public List<Book> createBooks (List<Book> books){return bookRepository.saveAll(books);}

    public String deleteBook (Long id){
        bookRepository.deleteById(id);
        return "Book deleted with id : " + id;
    }

    public Book updateBook(Book book, Long id){
        Book existingBook = bookRepository.findById(id).orElse(null);
        if(book.getBookName() != null)
            existingBook.setBookName(book.getBookName());
        if(book.getAuthor() != null)
            existingBook.setAuthor(book.getAuthor());
        if(book.getCategory() != null)
            existingBook.setCategory(book.getCategory());
        if(book.getCoverURL() != null)
            existingBook.setCoverURL(book.getCoverURL());
        if(book.getPages() != null)
            existingBook.setPages(book.getPages());
        if(book.getIsbn() != null)
            existingBook.setIsbn(book.getIsbn());
        if(book.getSummary() != null)
            existingBook.setSummary(book.getSummary());
        return bookRepository.save(existingBook);
    }

}
