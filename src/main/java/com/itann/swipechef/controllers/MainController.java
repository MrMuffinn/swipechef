package com.itann.swipechef.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @GetMapping("/index")
    public String indexHtml() {
        return "index2";
    }

    @GetMapping("/recepten")
    public String gerechtHtml() {
        return "gerecht1";
    }

    @GetMapping("/mijnKookboek")
    public String mijnkookboekHtml(){return "mijnkookboek";}

}
