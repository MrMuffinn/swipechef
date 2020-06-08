package com.itann.swipechef.controllers;

import com.itann.swipechef.services.EenheidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class AddControllers {

    @Autowired
    private EenheidService eenheidService;

//    @Autowired
//    private GebruikerService gebruikerService;


    @PostMapping("/eenheid/add")
    public String addNewEenheid(@RequestParam (name = "naam") String naam, Model model){
       eenheidService.postNieuweEenheid(naam);

        model.addAttribute("naam", naam);
        return "eenheidAdded";
    }

//    @PostMapping("/registreren/add")
//    public String addNewUser(@RequestParam (name = "voornaam") String voornaam,
//                             @RequestParam (name = "achternaam") String achternaam,
//                             @RequestParam (name = "email") String email,
//                             @RequestParam (name = "wachtwoord") String wachtwoord,
//                             @RequestParam (name = "rol") String rol, Model model) {
//        model.addAttribute("voornaam", voornaam);
//        model.addAttribute("achternaam", achternaam);
//
//        gebruikerService.postNieuweGebruiker(voornaam, achternaam, email, wachtwoord, rol);
//
//        return "gebruikerAdded";
//    }

}





