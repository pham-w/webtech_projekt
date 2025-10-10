package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SeiteController {
    @GetMapping("/seite")
        public List<Seite> getProfile() {
            return List.of(new Seite("M1",90, ));
    }
}
