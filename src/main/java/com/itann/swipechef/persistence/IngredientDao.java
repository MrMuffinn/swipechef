package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Ingredient;

import java.util.List;

public interface IngredientDao {

    public boolean save(Ingredient ingredient);
    // Zoek alle Ingredient
    public List<Ingredient> findAll();
    // Zoek een Ingredient op ID
    public Ingredient findById(int id);
    // Edit een Ingredient
    public boolean update(Ingredient ingredient);
    // Verwijder een Ingredient
    public boolean delete(Ingredient ingredient);
    // Zoek alle ingredienten die bij een gerecht horen
    public List<Ingredient> findByGerecht(Gerecht gerecht);

}
