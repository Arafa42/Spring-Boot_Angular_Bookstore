package com.arafa.books.model;

import javax.persistence.*;
import javax.validation.constraints.Email;

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
    @Email
    @Column(
            name="email",
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name="price"
    )
    private Double price;

    @Column(
            name="itemName",
            columnDefinition = "TEXT"
    )
    private String itemName;
    @Column(
            name="itemImageURL",
            columnDefinition = "TEXT"
    )
    private String itemImageURL;

    //@OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    //@JoinColumn(name = "order_id")
    //private List<Book> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //public List<Book> getProducts() {
    //    return products;
   // }

    //public void setProducts(List<Book> products) {
    //    this.products = products;
    //}

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImageURL() {
        return itemImageURL;
    }

    public void setItemImageURL(String itemImageURL) {
        this.itemImageURL = itemImageURL;
    }




    public Order(Long id, String email, /*List<Book> products*/Double price, String itemName, String itemImageURL) {
        this.id = id;
        this.email = email;
      //  this.products = products;
        this.price = price;
        this.itemName = itemName;
        this.itemImageURL = itemImageURL;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", price=" + price +
                ", itemName='" + itemName + '\'' +
                ", itemImageURL='" + itemImageURL + '\'' +
                '}';
    }

    public Order(){}

}
