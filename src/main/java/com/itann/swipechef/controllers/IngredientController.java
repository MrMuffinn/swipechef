package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Ingredient;
import com.itann.swipechef.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

//    @GetMapping("/ingredient")
//    public List<Ingredient> getGerechtById (@RequestParam(required = false) int id) {
//
//        return ingredientService.findIngredientenByGerechtId(id);
//    }

    @GetMapping("/ingredienten")
    public List<Ingredient> allUsers() {

        return ingredientService.findAll();
    }

    @GetMapping("/ingredienten/count")
    public int count() {

        return ingredientService.count();
    }

    @DeleteMapping("/ingredienten/{id}")
    public void delete(@PathVariable String id) {

        int ingredientId = Integer.parseInt(id);
        ingredientService.deleteById(ingredientId);
    }
}


