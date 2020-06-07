package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.services.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
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



}





