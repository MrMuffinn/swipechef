package com.itann.swipechef.domain;

import javax.persistence.*;

@Entity(name="ingredient")
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="gerecht")
    private int gerecht;
    @Column(name ="product")
    private String product;
    @Column(name="hoeveelheidPP")
    private int hoeveelheidPP;

//    public Ingredient(int id, Object gerecht, int hoeveelheidPP, Object product) {
//    }

//    public Ingredient(int id, Gerecht gerecht, Product product, int hoeveelheidPP) {
//    }
//
//    public Ingredient(int id, String gerecht, String product, int hoeveelheidPP) {
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGerecht() {
        return gerecht;
    }

    public void setGerecht(int gerecht) {
        this.gerecht = gerecht;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getHoeveelheidPP() {
        return hoeveelheidPP;
    }

    public void setHoeveelheidPP(int hoeveelheidPP) {
        this.hoeveelheidPP = hoeveelheidPP;
    }
}
