package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;

import java.util.List;

public interface GerechtDao {
    // Voeg een Gerecht toe
    public boolean save(Gerecht gerecht);
    // Zoek alle Gerechten
    public List<Gerecht> findAll();
    // Zoek een Gerecht op ID
    public Gerecht findById(int id);
    // Edit een Gerecht
    public boolean update(Gerecht gerecht);
    // Verwijder een Gerecht
    public boolean delete(Gerecht gerecht);
}
