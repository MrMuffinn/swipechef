package com.itann.swipechef.domain;

public class Product {
    private int id;
    private String naam;
    private Eenheid eenheid;
    private int energiePE;

    public Product(int id, String naam, String eenheid, int energiePE) {
    }


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

    public Eenheid getEenheid() {
        return eenheid;
    }

    public void setEenheid(Eenheid eenheid) {
        this.eenheid = eenheid;
    }

    public int getEnergiePE() {
        return energiePE;
    }

    public void setEnergiePE(int energiePE) {
        this.energiePE = energiePE;
    }
}
