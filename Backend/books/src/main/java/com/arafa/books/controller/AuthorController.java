package com.arafa.books.controller;
import com.arafa.books.model.Author;
import com.arafa.books.repository.AuthorRepository;
import com.arafa.books.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/authors")
@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    private AuthorRepository authorRepository;

      public AuthorController(AuthorService authorService,AuthorRepository authorRepository){
          this.authorService = authorService;
         this.authorRepository = authorRepository;
      }


      @PostMapping("/create")
      public ResponseEntity<Object> createAuthorr(@RequestBody Author author){
          return authorService.addAuthor(author);
      }

      @GetMapping("/details/{id}")
      public Author getOrderr(@PathVariable Long id){
          if(authorRepository.findById(id).isPresent()) {
          return authorRepository.findById(id).get();
          }
          else{
              return null;
          }
          }

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


    // @Autowired
    // private OrderService orderService;
    // private OrderRepository orderRepository;

    //  public OrderController(OrderService orderService,OrderRepository orderRepository){
    //      this.orderService = orderService;
    //     this.orderRepository = orderRepository;
    //  }

    //  @PostMapping("/create")
    //  public ResponseEntity<Object> createOrder(@RequestBody Order order){
    //      return orderService.addOrder(order);
    //  }

    //  @GetMapping("/details/{id}")
    //  public Order getOrder(@PathVariable Long id){
    //      if(orderRepository.findById(id).isPresent()) {
    //      return orderRepository.findById(id).get();
    //      }
    //      else{
    //          return null;
    //      }
    //      }


}