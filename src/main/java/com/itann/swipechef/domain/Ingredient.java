package com.itann.swipechef.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "ingredient")
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "gerecht")
    private int gerecht;
    @Column(name = "product")
    private String product;
    @Column(name = "hoeveelheidPP")
    private int hoeveelheidPP;

}
