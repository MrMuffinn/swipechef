package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gebruiker;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GebruikerDao {
    // Voeg een Gebruiker toe
    public boolean save(Gebruiker gebruiker);

    // Zoek een Gebruiker op e-mailadres
    public Gebruiker findByEmail(String email);


    public Gebruiker findById(int id);
}
