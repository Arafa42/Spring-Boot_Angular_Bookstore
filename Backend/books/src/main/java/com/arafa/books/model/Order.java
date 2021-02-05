package com.arafa.books.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity(name = "com.arafa.BooksApplication.Order")
@Table(name="orders")
public class Order {

    @Id
    @SequenceGenerator(
            name="order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="totalPrice"
    )
    private Double totalPrice;
    @Column(
            name="amount"
    )
    private Integer amount;
    @Email
    @Column(
            name="email",
            columnDefinition = "TEXT"
    )
    private String email;

    @OneToMany
    @Column(
            name="products"
    )
    private List<Book> products;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Book> getProducts() {
        return products;
    }

    public void setProducts(List<Book> products) {
        this.products = products;
    }

    public Order(Long id, Double totalPrice, Integer amount, String email, List<Book> products) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.amount = amount;
        this.email = email;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", amount=" + amount +
                ", products=" + products +
                '}';
    }

    public Order(){}

}
