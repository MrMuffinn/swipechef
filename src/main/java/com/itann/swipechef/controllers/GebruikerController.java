package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.services.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping(path = "/gebruiker")
public class GebruikerController {

    @Autowired
    private GebruikerService gebruikerService;

    @GetMapping("/gebruiker")
    public Optional<Gebruiker> getGebruiker(@RequestParam(required = false) int id) {

        return gebruikerService.getGebruikerOpId(id);
    }

    @GetMapping("/inloggen")
    public ResponseEntity<Gebruiker> inloggen(@RequestParam String email) {

//        if (wachtwoordHoortBijGebruiker(wachtwoord)) {
//            return new ResponseEntity<>(
//                    "U bent ingelod", HttpStatus.OK);
//        }

        return ResponseEntity.ok(gebruikerService.getGebruikerOpEmail(email));
    }

    @PostMapping("/registreren")
    public ResponseEntity<Gebruiker> addNewUser(@RequestParam String voornaam,
                                     @RequestParam String achternaam,
                                     @RequestParam String email,
                                     @RequestParam String wachtwoord,
                                                @RequestParam String rol) {

        return ResponseEntity.ok(gebruikerService.postNieuweGebruiker(voornaam, achternaam, email, wachtwoord, rol));
    }

}





