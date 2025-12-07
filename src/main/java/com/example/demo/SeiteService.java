package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeiteService {

    @Autowired
    SeiteRepository repo;

    public Seite save(Seite seite) {
        return repo.save(seite);
    }

    public Seite get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }
}
