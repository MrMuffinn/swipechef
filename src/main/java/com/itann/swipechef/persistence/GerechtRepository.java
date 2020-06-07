package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public interface GerechtRepository extends CrudRepository<Gerecht, Integer> {

      List<Gerecht> findByNaam(String naam);

//    @Query("SELECT distinct I.id, I.gerecht, I.hoeveelheidPP, I.product FROM gerecht G, ingredient I  where G.id = I.gerecht")
//    List<Ingredient> getIngredientenByGerecht();

//    @Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",
//            nativeQuery = true)
//    User findUserByStatusAndNameNamedParamsNative(
//            @Param("status") Integer status, @Param("name") String name);
//
//    @Query(value = "SELECT I.*  FROM gerecht G, ingredient I  where G.id = :names")
//    List<Ingredient> findUserByNameList(@Param("gerecht") Collection<String> names);

}

