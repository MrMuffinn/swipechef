package com.itann.swipechef.services;

import com.itann.swipechef.domain.Eenheid;
import com.itann.swipechef.persistence.EenheidDao;

import java.util.List;

public class EenheidService {

    private EenheidDao dao;

    public EenheidService(EenheidDao dao){this.dao = dao;}

    public Eenheid getByName(String naam) {return dao.findByName(naam);}

    public List<Eenheid> getAll(){ return dao.findAll();}

    public boolean save(Eenheid eenheid){ return dao.save(eenheid); }

    public boolean update(Eenheid eenheid){return dao.update(eenheid);}

    public boolean delete(Eenheid eenheid){return dao.delete(eenheid);}

}
