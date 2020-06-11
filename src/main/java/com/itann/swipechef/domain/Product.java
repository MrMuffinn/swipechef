package com.itann.swipechef.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "product")
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="naam", insertable = false, updatable = false)
    private String naam;
    @Column(name = "eenheid")
    private String eenheid;
    @Column(name = "energiePE")
    private int energiePE;

}
