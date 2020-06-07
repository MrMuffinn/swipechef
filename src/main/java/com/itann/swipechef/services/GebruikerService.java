package com.itann.swipechef.services;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.persistence.GebruikerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GebruikerService {

    @Autowired
    private GebruikerRepository gebruikersRepository;

    public Gebruiker getGebruikerOpEmail(String email) {
        return gebruikersRepository.findByEmail(email);
    }

    public Optional<Gebruiker> getGebruikerOpId(int id) {
        return gebruikersRepository.findById(id);
    }

    public Gebruiker postNieuweGebruiker(String voornaam, String achternaam, String email, String wachtwoord, String rol) {
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setVoornaam(voornaam);
        gebruiker.setAchternaam(achternaam);
        gebruiker.setEmail(email);
        gebruiker.setWachtwoord(wachtwoord);
        gebruiker.setRol(rol);
        return gebruikersRepository.save(gebruiker);
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
