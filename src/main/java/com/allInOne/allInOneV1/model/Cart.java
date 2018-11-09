package com.allInOne.allInOneV1.model;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;


}
