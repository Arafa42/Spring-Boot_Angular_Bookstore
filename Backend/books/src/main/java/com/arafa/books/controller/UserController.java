package com.arafa.books.controller;

import com.arafa.books.model.Book;
import com.arafa.books.model.User;
import com.arafa.books.service.BookService;
import com.arafa.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){return userService.createUser(user);}

    @GetMapping("/getById/{id}")
    public User getUserById(@PathVariable Long id){return userService.getUserbyId(id);}

    @GetMapping("/getByMail/{email}")
    public User getUserByEmail(@PathVariable String email){return userService.getUserbyEmail(email);}

    @GetMapping()
    public List<User> getAllUsers(){return userService.getAllUsers();}

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Long id){return userService.deleteUser(id);}

    @PutMapping("{email}")
    public User updateBook(@PathVariable String email,@Valid @RequestBody User user){return userService.updateUser(user,email);}

}
