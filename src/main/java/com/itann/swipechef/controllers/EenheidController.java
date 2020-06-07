package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Eenheid;
import com.itann.swipechef.persistence.EenheidRepository;
import com.itann.swipechef.services.EenheidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EenheidController {

    @Autowired
    public EenheidRepository eenheidRepository;
    @Autowired
    public EenheidService eenheidService;

    @GetMapping("/eenheid")
    public Eenheid getEenheid (@RequestParam(required = false) String naam) {

        return eenheidService.getEenheidOpNaam(naam);
    }

    @GetMapping("/eenheden")
    public Iterable<Eenheid> getAllEenheden(){
        return eenheidRepository.findAll();
    }
}
