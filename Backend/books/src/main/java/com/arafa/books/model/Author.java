package com.arafa.books.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "com.arafa.books.BooksApplication.Author")
@Table(name="author")
public class Author {

    @Id
    @SequenceGenerator(
            name="author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator = "author_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name="firstname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name="lastname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name="birthdate",
            columnDefinition = "TEXT"
    )
    private String birthdate;
    @Column(
            name="lifeDescription",
            columnDefinition = "TEXT"
    )
    private String lifeDescription;
    @Column(
            name="authorImageURL",
            columnDefinition = "TEXT"
    )
    private String authorImageURL;
    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private List<Book> products;

    public List<Book> getProducts() {
        return products;
    }

    public void setProducts(List<Book> products) {
        this.products = products;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    public String getLifeDescription() {
        return lifeDescription;
    }

    public void setLifeDescription(String lifeDescription) {
        this.lifeDescription = lifeDescription;
    }

    public String getAuthorImageURL() {return authorImageURL; }

    public void setAuthorImageURL(String authorImageURL) { this.authorImageURL = authorImageURL; }

    public Author(String firstName, String lastName, String birthdate, String lifeDescription,String authorImageURL,List<Book> books){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.lifeDescription = lifeDescription;
        this.authorImageURL = authorImageURL;
        this.products = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", lifeDescription='" + lifeDescription + '\'' +
                ", authorImageURL='" + authorImageURL + '\'' +
                '}';
    }

    public Author(){}

}
