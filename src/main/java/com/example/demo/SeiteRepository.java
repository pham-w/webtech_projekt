package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SeiteRepository extends CrudRepository<Seite, Long> {
    List<Seite> findByUserId(Long userId);
}