package com.itann.swipechef.services;

import com.itann.swipechef.controllers.WachtwoordOnjuistException;
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

    public Gebruiker postNieuweGebruiker(String voornaam, String achternaam, String email, String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setVoornaam(voornaam);
        gebruiker.setAchternaam(achternaam);
        gebruiker.setEmail(email);
        gebruiker.setWachtwoord(wachtwoord);
        gebruiker.setRol("USER");
        return gebruikersRepository.save(gebruiker);
    }

    public Gebruiker inloggenGebruiker(String email, String wachtwoord) {

        Gebruiker gebruiker = gebruikersRepository.findByEmail(email);

        if (gebruiker.getWachtwoord().equals(wachtwoord)) {
            return gebruiker;
        } else
            throw new WachtwoordOnjuistException();
    }

//    public boolean controleWachtwoord() {
//        if (userName.trim().equals("admin") && password.trim().equals("admin")) {
//            message.setText(" Hello " + userName + "");
//        } else {
//            message.setText(" Invalid user.. ");
//        }
//    }

}
