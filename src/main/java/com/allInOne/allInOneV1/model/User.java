package com.allInOne.allInOneV1.model;

import javax.persistence.*;
import java.util.*;

/**
 * User entity - contains information of all the users who have registered in out application
 *
 * */

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

//    @OneToMany(mappedBy="user")
//    private Set<Rating> ratings;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Set<Rating> getRatings() {
//        return ratings;
//    }
//
//    public void setRatings(Set<Rating> ratings) {
//        this.ratings = ratings;
//    }
}
