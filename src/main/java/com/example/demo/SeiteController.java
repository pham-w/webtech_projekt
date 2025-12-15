package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "https://frontend-freundebuch.onrender.com")
@RestController
public class SeiteController {

    @Autowired
    SeiteService service;

    @CrossOrigin
    @PostMapping("/seite")
    public Seite fillSeite(@RequestBody Seite seite) {
        return service.save(seite);
    }

    @CrossOrigin
    @GetMapping("/seite/{id}")
    public Seite getSeite(@PathVariable String id) {
        Long seiteId = Long.parseLong(id);
        return service.get(seiteId);
    }

    @GetMapping("/test")
    public Seite createTestSeite() {
        Seite s = new Seite(
                "Angi",
                19,
                LocalDate.of(2005, 1, 1),
                "Blau",
                "Karate",
                "Pizza",
                "Dev"
        );
        return service.save(s);
    }

}
