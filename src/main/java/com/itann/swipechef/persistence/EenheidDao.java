package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Eenheid;

import java.util.List;

public interface EenheidDao {

    public boolean save(Eenheid eenheid);
    // zoek alle eenheden
    public List<Eenheid> findAll();
    // Edit een eenheid
    public boolean update(Eenheid eenheid);
    // Verwijder een eenheid
    public boolean delete(Eenheid eenheid);
    // zoek op naam
    public Eenheid findByName(String naam);




}
