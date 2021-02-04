package com.arafa.books.service;


import com.arafa.books.model.Book;
import com.arafa.books.model.User;
import com.arafa.books.repository.BookRepository;
import com.arafa.books.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public User getUserbyId(Long id){return userRepository.findById(id).orElse(null);}
    public User getUserbyEmail(String email){return userRepository.findByEmail(email).orElse(null);}
    public List<User> getAllUsers(){return userRepository.findAll();}
    public User createUser(User user){return userRepository.save(user);}
    public String deleteUser (Long id){ userRepository.deleteById(id); return "User deleted with id : " + id; }

    public User updateUser(User user, String email){
        User existingUser = userRepository.findByEmail(email).orElse(null);
        if(user.getFirstName() != null)
            existingUser.setFirstName(user.getFirstName());
        if(user.getLastName() != null)
            existingUser.setLastName(user.getLastName());
        if(user.getEmail() != null)
            existingUser.setEmail(user.getEmail());
        if(user.getAddress() != null)
            existingUser.setAddress(user.getAddress());
        if(user.getPostcode() != null)
            existingUser.setPostcode(user.getPostcode());
        if(user.getGemeente() != null)
            existingUser.setGemeente(user.getGemeente());
        if(user.getGebdatum() != null)
            existingUser.setGebdatum(user.getGebdatum());
        if(user.getGender() != null)
            existingUser.setGender(user.getGender());
        return userRepository.save(existingUser);
    }



}
