package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
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

    public List<Seite> getAllForUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public Seite update(Long id, Seite updated, Long userId) {
        Seite existing = get(id);

        if (!userId.equals(existing.getUserId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Kein Zugriff");
        }

        existing.setName(updated.getName());
        existing.setAge(updated.getAge());
        existing.setGeburtsdatum(updated.getGeburtsdatum());
        existing.setFavColor(updated.getFavColor());
        existing.setHobby(updated.getHobby());
        existing.setFavFood(updated.getFavFood());
        existing.setDreamJob(updated.getDreamJob());

        // userId nicht ändern lassen!
        return repo.save(existing);
    }

    public void delete(Long id, Long userId) {
        Seite existing = get(id);

        if (!userId.equals(existing.getUserId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Kein Zugriff");
        }

        repo.deleteById(id);
    }
}
