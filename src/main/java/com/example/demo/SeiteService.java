package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class SeiteService {

    @Autowired
    SeiteRepository repo;

    public Seite save(Seite seite) {
        return repo.save(seite);
    }

    public Seite get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Seite not found: " + id));
    }
}
