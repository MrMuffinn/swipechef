package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    @Query("SELECT distinct I.id as id, I.gerecht as gerecht, I.hoeveelheidPP as hoeveelheidPP, I.product as product, P.eenheid as eenheid FROM ingredient I, product P where I.product = P.naam")
    Iterable<Ingredient> findAllInfo();

//    @Query("SELECT distinct I.id, I.gerecht, I.hoeveelheidPP, I.product, P.eenheid FROM ingredient I, product P where I.product = P.naam")
//    Iterable<IngredientExtra> findAllInfo();
//
//    List<Ingredient> findIngredientByGerechtId(int gerecht);

}
