package org.example.sqch8ex4.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/home/{color}")
    public String home(
            @PathVariable String color,
            Model page
    ){
        page.addAttribute("color", color);
        page.addAttribute("username", "Alina");


        return "home.html";
    }
}
