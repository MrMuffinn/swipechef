package com.itann.swipechef.domain;

public class Ingredient {

    private int id;
    private Gerecht gerecht;
    private Product product;
    private int hoeveelheidPP;

    public Ingredient(int id, Gerecht gerecht, Product product, int hoeveelheidPP) {
    }

    public Ingredient(int id, String gerecht, String product, int hoeveelheidPP) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGerecht(Gerecht gerecht) {
        this.gerecht = gerecht;
    }

    public Gerecht getGerecht() {
        return gerecht;
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
