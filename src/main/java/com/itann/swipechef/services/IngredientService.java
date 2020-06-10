package com.itann.swipechef.services;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Ingredient;
import com.itann.swipechef.persistence.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;

//    public List<Ingredient> findIngredientenByGerechtId(int gerecht) {
//        List<Ingredient> it = ingredientRepository.findIngredientByGerechtId(gerecht);
//
//        List<Ingredient> ingredienten = new ArrayList<Ingredient>();
//        it.forEach(e -> ingredienten.add(e));
//
//        return ingredienten;
//    }

    public List<Ingredient> findAll() {

        var it = ingredientRepository.findAll();

        var ingredienten = new ArrayList<Ingredient>();
        it.forEach(e -> ingredienten.add(e));

        return ingredienten;
    }

    public Iterable<Ingredient> findAllInfo(){
        return ingredientRepository.findAllInfo();
    }

    public int count() {

        return (int) ingredientRepository.count();
    }

    public void deleteById(int ingredientId) {

        ingredientRepository.deleteById(ingredientId);
    }

}
