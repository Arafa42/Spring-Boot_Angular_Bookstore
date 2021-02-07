package com.arafa.books.controller;


import com.arafa.books.model.Book;
import com.arafa.books.model.Order;
import com.arafa.books.model.User;
import com.arafa.books.repository.OrderRepository;
import com.arafa.books.service.BookService;
import com.arafa.books.service.OrderService;
import com.arafa.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder/{email}")
    public Order createOrder(@RequestBody  Order order,@PathVariable String email){return orderService.createOrder(order,email);}

    @GetMapping("{id}")
    public Order getOrderById(@PathVariable Long id){return orderService.getOrderById(id);}

    @GetMapping("/getByMail/{email}")
    public List<Order> getOrdersByMail(@PathVariable String email){return orderService.getOrdersByEmail(email);}

    @DeleteMapping("{id}")
    public String deleteOrderById(@PathVariable Long id){return orderService.deleteOrder(id);}

    @DeleteMapping("{email}/{id}")
    public String deleteOrdersByMail(@PathVariable Long id,@PathVariable String email){return orderService.deleteOrderByMail(id,email);}

    @DeleteMapping("deleteByMail/{email}")
    public String deleteAllOrdersByMail(@PathVariable String email){return orderService.deleteAllOrdersByMail(email);}

    }