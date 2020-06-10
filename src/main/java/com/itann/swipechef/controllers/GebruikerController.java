package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.services.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/gebruiker")
public class GebruikerController {

    @Autowired
    private GebruikerService gebruikerService;

    @GetMapping("/gebruiker")
    public @ResponseBody
    Optional<Gebruiker> getGebruiker(@RequestParam(required = false) int id) {

        return gebruikerService.getGebruikerOpId(id);
    }

    @PostMapping("/registreren")
    public String registreren() {
        return "registreren";
    }

    @PostMapping("/accountaanmaken")
    public String addNewUser(@RequestParam(name = "voornaam") String voornaam,
                             @RequestParam(name = "achternaam") String achternaam,
                             @RequestParam(name = "email") String email,
                             @RequestParam(name = "wachtwoord") String wachtwoord) {

        gebruikerService.postNieuweGebruiker(voornaam, achternaam, email, wachtwoord);

        return "accountaangemaakt";
    }

    @PostMapping("/inloggen")
    public String getUserByEmail(@RequestParam(required = true) String email,
                                 @RequestParam(required = true) String wachtwoord) {

        try {
            gebruikerService.inloggenGebruiker(email, wachtwoord);
        } catch (WachtwoordOnjuistException wachtwoordOnjuistException) {
            return "wachtwoordonjuist";
        }

        return "accountaangemaakt";

    }

    @GetMapping("/inloggen")
    public String inloggenHtml() {
        return "inloggen";
    }



}





