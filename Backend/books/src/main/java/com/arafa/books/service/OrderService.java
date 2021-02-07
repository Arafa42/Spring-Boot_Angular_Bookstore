package com.arafa.books.service;

import com.arafa.books.model.Book;
import com.arafa.books.model.Order;
import com.arafa.books.model.User;
import com.arafa.books.repository.BookRepository;
import com.arafa.books.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long id){return orderRepository.findById(id).orElse(null);}
    public List<Order> getOrdersByEmail(String email){return orderRepository.findByEmail(email).orElse(null);}
    public Order createOrder(Order order,String email){return orderRepository.save(order);}
    public String deleteOrder (Long id){ orderRepository.deleteById(id); return "Order deleted with id : " + id; }
    public String deleteOrderByMail (Long id, String email){orderRepository.deleteById(id); return "order deleted with id : " + id;}
    public String deleteAllOrdersByMail (String email){orderRepository.deleteAll(); return "orders deleted of user : " + email;}


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