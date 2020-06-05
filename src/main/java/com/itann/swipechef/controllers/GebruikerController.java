package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.services.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//@RequestMapping(path = "/gebruiker")
public class GebruikerController {

    @Autowired
    private GebruikerService gebruikerService;

    @GetMapping("/gebruiker")
    public @ResponseBody Optional<Gebruiker> getGebruiker(@RequestParam(required = false) int id) {

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
    public String addNewUser(@RequestParam(name = "voornaam") String voornaam,
                             @RequestParam(name = "achternaam") String achternaam,
                             @RequestParam(name = "email") String email,
                             @RequestParam(name = "wachtwoord") String wachtwoord,
                             @RequestParam(name = "rol") String rol, Model model) {

        gebruikerService.postNieuweGebruiker(voornaam, achternaam, email, wachtwoord, rol);

        return "gebruikerAdded";
    }

//    @PostMapping("/inloggen")
//    public String getUserByEmail(@RequestParam(name = "email") String email,
//                             @RequestParam(name = "wachtwoord") String wachtwoord, Model model) {
//
//        gebruikerService.inloggenGebruiker(email, wachtwoord);
//
//        return "gebruikerAdded";
//    }

}





