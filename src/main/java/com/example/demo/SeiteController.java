package com.example.demo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://frontend-freundebuch.onrender.com")
public class SeiteController {
    @GetMapping("/seite")
        public List<Seite> getProfile() {
            return List.of(new Seite("Willhelm",90,  LocalDate.of(2000, 10, 1), "Blau", "backen", "pizza", "astronaut"));
    }
}
