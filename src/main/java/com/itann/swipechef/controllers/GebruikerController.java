package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.persistence.GebruikerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gebruiker")
public class GebruikerController {


    @PostMapping("/registreren")
    public String toevoegenGebruiker(@RequestParam(name = "voornaam") String voornaam, @RequestParam(name = "achternaam")
            String achternaam, @RequestParam(name = "email") String email, @RequestParam(name = "wachtwoord")
                                             String wachtwoord, @RequestParam(name = "rol") String rol, Model model) {

        return "accountAangemaakt";
    }



}


