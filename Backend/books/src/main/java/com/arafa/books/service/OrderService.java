package com.arafa.books.service;

import com.arafa.books.model.Book;
import com.arafa.books.model.Order;
import com.arafa.books.repository.BookRepository;
import com.arafa.books.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    public Order getOrdersByMail(String email){return orderRepository.findByEmail(email).orElse(null);}

    public Order createOrder(Order order){return orderRepository.save(order);}

    public String deleteOrder (Long id){
        orderRepository.deleteById(id);
        return "Book deleted with id : " + id;
    }

}
