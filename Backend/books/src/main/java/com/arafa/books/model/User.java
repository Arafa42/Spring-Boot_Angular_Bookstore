package com.arafa.books.model;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity(name = "com.arafa.BooksApplication.User")
@Table(name="users")
public class User {


    @Id
    @SequenceGenerator(
            name="users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="firstName",
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name="lastName",
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Email
    @Column(
            name="email",
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name="address",
            columnDefinition = "TEXT"
    )
    private String address;
    @Column(
            name="postcode",
            columnDefinition = "INTEGER"
    )
    private Integer postcode;
    @Column(
            name="gemeente",
            columnDefinition = "TEXT"
    )
    private String gemeente;
    @Column(
            name="gebdatum",
            columnDefinition = "TEXT"
    )
    private String gebdatum;
    @Column(
            name="gender",
            columnDefinition = "TEXT"
    )
    private String gender;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public String getGebdatum() { return gebdatum; }

    public void setGebdatum(String gebdatum) { this.gebdatum = gebdatum; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }


    public User(Long id, String firstName, String lastName, @Email String email, String address, Integer postcode, String gemeente, String gebdatum, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.gebdatum = gebdatum;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", postcode=" + postcode +
                ", gemeente='" + gemeente + '\'' +
                ", gebdatum='" + gebdatum + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public User(){}


}
