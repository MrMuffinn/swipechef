package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

//    List<Ingredient> findIngredientByGerechtId(int gerecht);
}
