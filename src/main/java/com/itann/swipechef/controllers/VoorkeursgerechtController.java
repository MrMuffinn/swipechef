package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Voorkeursgerecht;
import com.itann.swipechef.services.VoorkeursgerechtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoorkeursgerechtController {

    @Autowired
    VoorkeursgerechtService voorkeursgerechtService;

    @PostMapping("/voorkeursgerecht/add")
    public String addNewVoorkeur(@RequestParam(name = "gerecht") int gerecht) {

        voorkeursgerechtService.postNieuwVoorkeursgereceht(gerecht);

        return "voorkeursgerechtAdded";
    }

    @GetMapping("/voorkeursgerechten")
    public Iterable<Voorkeursgerecht> getAllGerechten() {
        return voorkeursgerechtService.findAll();
    }

//    @GetMapping("/allegerechten")
//    public Iterable<Voorkeursgerecht> getAllGerechtInfo(){
//        return voorkeursgerechtService.findAllGerechten();
//    }


}
