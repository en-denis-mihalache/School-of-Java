package com.example.sqch10ex3.controller;

import com.example.sqch10ex3.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france(){
        Country country = Country.of("France",67);
        return country;
    }

    @GetMapping("/all")
    public List<Country> all(){
        Country c1 = Country.of("France",67);
        Country c2 = Country.of("Spain",44);

        return Arrays.asList(c1,c2);
    }
}
