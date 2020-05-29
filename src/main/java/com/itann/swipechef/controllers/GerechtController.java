package com.itann.swipechef.controllers;

import com.google.gson.Gson;
import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.persistence.GerechtMySQLDaoImpl;
import com.itann.swipechef.services.GerechtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gerechten")
public class GerechtController {

    private GerechtService gerechtService = new GerechtService(new GerechtMySQLDaoImpl());

    @GetMapping(produces = "application/json")
    public String getAll(){
        Gson gson = new Gson();
        return gson.toJson(this.gerechtService.getAll());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public String getGerecht(@PathVariable int id) {
        Gson gson = new Gson();
        return gson.toJson(this.gerechtService.getById(id));
    }
}
