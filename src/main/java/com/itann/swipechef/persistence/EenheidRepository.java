package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Eenheid;
import com.itann.swipechef.domain.Gebruiker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EenheidRepository extends CrudRepository<Eenheid, Integer> {

    Eenheid findByNaam(@Param("naam") String naam);
}
