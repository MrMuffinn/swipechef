package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GerechtRepository extends CrudRepository<Gerecht, Integer> {

      String findByNaam(String naam);

      @Query("SELECT distinct G FROM gerecht G, voorkeursgerecht V where G.id = V.gerecht")
      Iterable <Gerecht> findAllVoorkeurgerechten();

//    @Query("SELECT distinct I.id, I.gerecht, I.hoeveelheidPP, I.product FROM gerecht G, ingredient I  where G.id = I.gerecht")
//    List<Ingredient> getIngredientenByGerecht();
//
//    @Query(value = "SELECT * FROM Users u WHERE u.status = :status and u.name = :name",
//            nativeQuery = true)
//    User findUserByStatusAndNameNamedParamsNative(
//            @Param("status") Integer status, @Param("name") String name);
//
//    @Query(value = "SELECT I.*  FROM gerecht G, ingredient I  where G.id = :names")
//    List<Ingredient> findUserByNameList(@Param("gerecht") Collection<String> names);
//            @Query("SELECT distinct G.id, G.naam, G.energiePP, G.bereidingstijd, G.bereidingswijze  FROM gerecht G, voorkeursgerecht V where G.id =V.gerecht")
//      Iterable <Gerecht> findAllVoorkeurgerechten();

}

