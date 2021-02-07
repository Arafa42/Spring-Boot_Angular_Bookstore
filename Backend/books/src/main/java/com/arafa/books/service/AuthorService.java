package com.arafa.books.service;

import com.arafa.books.exception.CustomRequestException;
import com.arafa.books.model.Author;
import com.arafa.books.repository.AuthorRepository;
import com.arafa.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

     public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository){
         this.authorRepository = authorRepository;
         this.bookRepository = bookRepository;
    }



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



    @Transactional
    public ResponseEntity<Object> addAuthor(Author order){
         Author newAuthor = new Author();
         newAuthor.setFirstName(order.getFirstName());
         newAuthor.setLastName(order.getLastName());
         newAuthor.setAuthorImageURL(order.getAuthorImageURL());
         newAuthor.setBirthdate(order.getBirthdate());
         newAuthor.setLifeDescription(order.getLifeDescription());
         newAuthor.setProducts(order.getProducts());

        Author savedAuthor = authorRepository.save(newAuthor);
        if(authorRepository.findById(savedAuthor.getId()).isPresent())
        {
            return ResponseEntity.accepted().body("Succes");
        }
        else{
            return ResponseEntity.unprocessableEntity().body("Failed");
        }
     }




    //  @Autowired
    //  private OrderRepository orderRepository;

    // private BookRepository bookRepository;

    // public OrderService(OrderRepository orderRepository,BookRepository bookRepository){
    //     this.orderRepository = orderRepository;
    //     this.bookRepository = bookRepository;
    // }

    // @Transactional
    // public ResponseEntity<Object> addOrder(Order order){
    //     Order newOrder = new Order();
    //     newOrder.setAmount(order.getAmount());
    //     newOrder.setTotalPrice(order.getTotalPrice());
    //    newOrder.setEmail(order.getEmail());
    //    newOrder.setProducts(order.getProducts());
    //    Order savedOrder = orderRepository.save(newOrder);
    //    if(orderRepository.findById(savedOrder.getId()).isPresent())
    //    {
    //        return ResponseEntity.accepted().body("Succes");
    //    }
    //    else{
    //        return ResponseEntity.unprocessableEntity().body("Failed");
    //    }
    // }
}