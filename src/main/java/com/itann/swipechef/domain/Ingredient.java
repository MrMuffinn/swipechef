package com.itann.swipechef.domain;

import javax.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "naam")
    private int gerecht;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "naam")
    private Product product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getHoeveelheidPP() {
        return hoeveelheidPP;
    }

    public void setHoeveelheidPP(int hoeveelheidPP) {
        this.hoeveelheidPP = hoeveelheidPP;
    }
}
