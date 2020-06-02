package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.persistence.GebruikerRepository;
import com.itann.swipechef.services.GebruikerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/gebruiker")
public class GebruikerController {

    @Autowired
    private GebruikerService gebruikerService;

    @Autowired
    private GebruikerRepository gebruikerRepository;

    @GetMapping("/inloggen")
    public ResponseEntity<Gebruiker> inloggen(@RequestParam String email) {

//        if (wachtwoordHoortBijGebruiker(wachtwoord)) {
//            return new ResponseEntity<>(
//                    "U bent ingelod", HttpStatus.OK);
//        }

        return ResponseEntity.ok(gebruikerService.getGebruikerOpEmail(email));
    }

    @PostMapping("/registreren")
    public String addNewUser(@RequestParam String voornaam,
                                     @RequestParam String achternaam,
                                     @RequestParam String email,
                                     @RequestParam String wachtwoord) {
        Gebruiker gebruiker = new Gebruiker();
        gebruiker.setVoornaam(voornaam);
        gebruiker.setAchternaam(achternaam);
        gebruiker.setEmail(email);
        gebruiker.setWachtwoord(wachtwoord);
        gebruikerRepository.save(gebruiker);
        return "accountAangemaakt";
    }

}





