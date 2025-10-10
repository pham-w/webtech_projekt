package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class SeiteController {
    @GetMapping("/seite")
        public List<Seite> getProfile() {
            return List.of(new Seite("Willhelm",90,  LocalDate.of(2000, 10, 1), "Blau", "backen", "pizza", "astronaut"));
    }
}
