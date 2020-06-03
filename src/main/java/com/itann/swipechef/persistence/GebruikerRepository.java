package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gebruiker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GebruikerRepository extends CrudRepository<Gebruiker, Integer> {


//    public boolean save(Gebruiker gebruiker);

    Gebruiker findByEmail(@Param("email") String email);

//    String toevoegenGebruiker(@Param("voornaam") String voornaam, @Param("achternaam") String achternaam, @Param("email") String email, @Param("wachtwoord") String wachtwoord);


//    Gebruiker findById(int id);
}
