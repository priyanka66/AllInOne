package com.allInOne.allInOneV1.model;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int itemId;


}
