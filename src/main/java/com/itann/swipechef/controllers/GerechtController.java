package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.persistence.GerechtRepository;
import com.itann.swipechef.services.GerechtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping
public class GerechtController {

    @Autowired
    private GerechtRepository gerechtRepository;

    @Autowired
    private GerechtService gerechtService;

//    @Autowired
//    private Gerecht gerecht;
//
//    @Autowired
//    private Ingredient ingredient;



    @GetMapping("/gerechten")
    public Iterable<Gerecht> getAllGerechten(){
    return gerechtRepository.findAll();
    }

    @GetMapping("/gerecht")
    public Optional<Gerecht> getGerechtById (@RequestParam(required = false) int id) {

        return gerechtService.getGerechtById(id);
    }

    @GetMapping("/gerecht/naam")
    public String getGerechtByNaam (@RequestParam(required = false) String naam){
        return gerechtService.findGerechtByNaam(naam);
    }




//    @GetMapping("/ingredienten")
//    public List<Ingredient> getAllIngredientenByGerecht(){
//        return gerechtService.getIngredientByGerechten();
//    }


}
