package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.time.LocalDate;

@CrossOrigin(
        origins = "https://frontend-freundebuch.onrender.com",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
        allowedHeaders = "*"
)
@RestController
public class SeiteController {

    @Autowired
    private SeiteService service;

    @PostMapping("/seite")
    public Seite fillSeite(@RequestBody Seite seite) {
        if (seite.getUserId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "userId fehlt");
        }
        return service.save(seite);
    }


    @GetMapping("/seite")
    public List<Seite> getAllSeiten(@RequestParam Long userId) {
        return service.getAllForUser(userId);
    }

    @GetMapping("/seite/{id}")
    public Seite getSeite(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/seite/{id}")
    public Seite updateSeite(@PathVariable Long id, @RequestBody Seite seite, @RequestParam Long userId) {
        return service.update(id, seite, userId);
    }
    @DeleteMapping("/seite/{id}")
    public void deleteSeite(@PathVariable Long id, @RequestParam Long userId) {
        service.delete(id, userId);
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
        s.setUserId(1L); // <-- irgendein existierender User
        return service.save(s);
    }

}
