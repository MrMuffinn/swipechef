package com.itann.swipechef.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
@Data
//@Entity
public class IngredientExtra {


    private int id;
    private int gerecht;
    private String product;
    private int hoeveelheidPP;
    private String eenheid;

}
