package com.arafa.books.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "com.arafa.BooksApplication.Book")
@Table(name="book")
public class Book {

    @Id
    @SequenceGenerator(
            name="book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="bookname",
            columnDefinition = "TEXT"
    )
    private String bookName;

    @Column(
            name="author",
            columnDefinition = "TEXT"
    )
    private String author;

    @Column(
            name="pages"
    )
    private Integer pages;

    @Column(
            name="isbn"
    )
    private Long isbn;

    @Column(
            name="category",
            columnDefinition = "TEXT"
    )
    private String category;
    @Column(
            name="coverURL",
            columnDefinition = "TEXT"
    )
    private String coverURL;
    @Column(
            name="summary",
            columnDefinition = "TEXT"
    )
    private String summary;
    @Column(name="price")
    private Double price;
    @Column(name="rating")
    private Integer rating;

    @JsonIgnore
    @ManyToOne
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public Integer getRating() { return rating; }

    public void setRating(Integer rating) { this.rating = rating; }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", isbn=" + isbn +
                ", category='" + category + '\'' +
                ", coverURL='" + coverURL + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

    public Book(String bookName, String author, String category, Long isbn, String coverURL, String summary, Double price, Integer rating)
    {
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.coverURL = coverURL;
        this.summary = summary;
        this.price = price;
        this.rating = rating;
    }

    public Book(){}


}
