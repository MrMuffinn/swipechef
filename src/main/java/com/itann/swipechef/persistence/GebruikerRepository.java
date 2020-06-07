package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gebruiker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Integer> {

    @Query("select g from gebruiker g where g.email = ?1")
    Gebruiker findByEmail(String email);

}
