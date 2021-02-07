package com.arafa.books.service;

import com.arafa.books.exception.CustomRequestException;
import com.arafa.books.model.Author;
import com.arafa.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public List<Author> createAuthors(List<Author> authors){
        return authorRepository.saveAll(authors);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){ return authorRepository.findById(id).orElse(null);}

    public String deleteAuthor(Long id){
       try {
           authorRepository.deleteById(id);
       }
       catch (Exception e) {
           throw new CustomRequestException("Delete operation failde, no member with id : "+id);
       }
       return "Author deleted with id : " + id;
    }

    public Author updateAuthor(Author author,Long id){
        Author existingAuthor = authorRepository.findById(id).orElse(null);
        try {
        if(author.getFirstName() !=null)
            existingAuthor.setFirstName(author.getFirstName());
        if(author.getLastName() !=null)
            existingAuthor.setLastName(author.getLastName());
        if(author.getBirthdate() !=null)
            existingAuthor.setBirthdate(author.getBirthdate());
        if(author.getLifeDescription() !=null)
            existingAuthor.setLifeDescription(author.getLifeDescription());
        if(author.getAuthorImageURL() !=null)
            existingAuthor.setAuthorImageURL(author.getAuthorImageURL());
        }
        catch (Exception e) {throw new CustomRequestException("Update operation failed"); }
        return authorRepository.save(existingAuthor);
    }
}