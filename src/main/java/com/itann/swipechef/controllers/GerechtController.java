package com.itann.swipechef.controllers;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.persistence.GerechtRepository;
import com.itann.swipechef.services.GerechtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping
public class GerechtController {

    @Autowired
    private GerechtRepository gerechtRepository;

    @Autowired
    private GerechtService gerechtService;

    @GetMapping("/gerechten")
    public Iterable<Gerecht> getAllGerechten() {
        return gerechtRepository.findAll();
    }

    @GetMapping("/gerecht")
    public Optional<Gerecht> getGerechtById(@RequestParam(required = false) int id) {

        return gerechtService.getGerechtById(id);
    }

    @GetMapping("/gerecht/naam")
    public String getGerechtByNaam(@RequestParam(required = false) String naam) {
        return gerechtService.findGerechtByNaam(naam);
    }

    @GetMapping("/allegerechten")
    public Iterable<Gerecht> getAllGerechtInfo() {
        return gerechtService.findAllGerechten();
    }

//    @GetMapping("/ingredienten")
//    public List<Ingredient> getAllIngredientenByGerecht(){
//        return gerechtService.getIngredientByGerechten();
//    }


}
