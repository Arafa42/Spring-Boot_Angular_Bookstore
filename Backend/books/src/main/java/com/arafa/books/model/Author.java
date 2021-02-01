package com.arafa.books.model;


import javax.persistence.*;
import java.util.Date;

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
            name="birthdate"
    )
    private Date birthdate;
    @Column(
            name="lifeDescription",
            columnDefinition = "TEXT"
    )
    private String lifeDescription;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public String getLifeDescription() {
        return lifeDescription;
    }

    public void setLifeDescription(String lifeDescription) {
        this.lifeDescription = lifeDescription;
    }

    public Author(String firstName, String lastName, Date birthdate, String lifeDescription){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.lifeDescription = lifeDescription;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", lifeDescription='" + lifeDescription + '\'' +
                '}';
    }

    public Author(){}

}
