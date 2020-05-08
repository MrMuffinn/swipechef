package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;

import java.util.List;

public interface GerechtDao {
    public boolean save(Gerecht gerecht);
    public List<Gerecht> findAll();
    public Gerecht findById(Gerecht gerecht);
    public boolean update(Gerecht gerecht);
    public boolean delete(Gerecht gerecht);
}
