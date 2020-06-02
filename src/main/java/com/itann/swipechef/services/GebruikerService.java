package com.itann.swipechef.services;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.persistence.GebruikerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GebruikerService {

    @Autowired
    private GebruikerRepository gebruikersRepository;

    public Gebruiker getGebruikerOpEmail(String email) {
        return gebruikersRepository.findByEmail(email);
    }





 /*   private GebruikerDao dao;

    public GebruikerService(GebruikerDao dao) {
        this.dao = dao;
    }

    public Gebruiker getByEmail(String email) {
        return dao.findByEmail(email);
    }

    public boolean save(Gebruiker gebruiker) {
        return dao.save(gebruiker);
    }*/

}
