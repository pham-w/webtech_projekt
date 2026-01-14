package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;

@CrossOrigin(origins = "https://frontend-freundebuch.onrender.com")
@RestController
public class SeiteController {

    @Autowired
    private SeiteService service;

    @PostMapping("/seite")
    public Seite fillSeite(@RequestBody Seite seite) {
        return service.save(seite);
    }

    @GetMapping("/seite")
    public List<Seite> getAllSeiten() {
        return service.getAll();
    }

    @GetMapping("/seite/{id}")
    public Seite getSeite(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/seite/{id}")
    public Seite updateSeite(@PathVariable Long id, @RequestBody Seite seite) {
        return service.update(id, seite);
    }

    // Ein einziges Test-Endpoint reicht:
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
