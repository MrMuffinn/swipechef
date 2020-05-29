package com.itann.swipechef.services;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Ingredient;
import com.itann.swipechef.persistence.IngredientDao;

import java.util.List;


public class IngredientService {

    private IngredientDao dao;

    public IngredientService(IngredientDao dao) {
        this.dao = dao;
    }

    public Ingredient getById(int id) {
        return dao.findById(id);
    }

    public List<Ingredient> getAll() {
        return dao.findAll();
    }

    public boolean save(Ingredient ingredient) {
        return dao.save(ingredient);
    }

    public boolean update(Ingredient ingredient) {
        return dao.update (ingredient);
    }

    public boolean delete(Ingredient ingredient) {
        return dao.delete (ingredient);
    }

    public List<Ingredient> getByGerecht(Gerecht gerecht) {return dao.findByGerecht(gerecht);}
}
