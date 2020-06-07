package com.itann.swipechef.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Eenheid {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="naam")
    private String naam;



    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


