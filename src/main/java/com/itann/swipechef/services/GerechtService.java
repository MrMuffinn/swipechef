package com.itann.swipechef.services;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.persistence.GerechtDao;

import java.util.List;

public class GerechtService {

    private GerechtDao dao;

    public GerechtService(GerechtDao dao) {
        this.dao = dao;
    }

    public Gerecht getById(int id) {
        return dao.findById(id);
    }

    public List<Gerecht> getAll() {
        return dao.findAll();
    }

    public boolean save(Gerecht gerecht) {
        return dao.save(gerecht);
    }

    public boolean update(Gerecht gerecht) {
        return dao.update (gerecht);
    }

    public boolean delete(Gerecht gerecht) {
        return dao.delete (gerecht);
    }

}
