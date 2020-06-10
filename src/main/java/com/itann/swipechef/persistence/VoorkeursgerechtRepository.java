package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Voorkeursgerecht;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoorkeursgerechtRepository extends CrudRepository <Voorkeursgerecht, Integer> {


    @Query("SELECT distinct G.id, G.naam, G.energiePP, G.bereidingstijd, G.bereidingswijze  FROM gerecht G, voorkeursgerecht V where V.gerecht = G.id")
    Iterable <Voorkeursgerecht> findAllVoorkeurgerechten();
}
