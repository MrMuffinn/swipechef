package com.itann.swipechef.services;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.persistence.GebruikerDao;

public class GebruikerService {

    private GebruikerDao dao;

    public GebruikerService(GebruikerDao dao) {
        this.dao = dao;
    }

    public Gebruiker getByEmail(String email) {
        return dao.findByEmail(email);
    }

    public boolean save(Gebruiker gebruiker) {
        return dao.save(gebruiker);
    }

}
