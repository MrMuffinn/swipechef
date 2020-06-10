package com.itann.swipechef.domain;

import javax.persistence.*;

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getEnergiePE() {
        return energiePE;
    }

    public void setEnergiePE(int energiePE) {
        this.energiePE = energiePE;
    }

    public String getEenheid() {
        return eenheid;
    }

    public void setEenheid(String eenheid) {
        this.eenheid = eenheid;
    }
}
