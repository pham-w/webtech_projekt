package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SeiteServiceTest {

    @Mock
    private SeiteRepository repo;

    @InjectMocks
    private SeiteService seiteService;

    @Test
    void update_IdDoesNotMatch_badPath() {
        Long id = 42L;
        Seite existing = new Seite("Eva", LocalDate.of(2012, 2, 2), "rot", "tanzen", "Kuchen", "Lehrer");
        existing.setId(id);
        existing.setUserId(99L);

        Seite updated = new Seite("EveUpdated", LocalDate.of(2012, 2, 2), "rot", "tanzen", "Kuchen", "Lehrer");

        when(repo.findById(id)).thenReturn(Optional.of(existing));

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> seiteService.update(id, updated, 1L));

        assertThat(ex.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }

    @Test
    void delete_IdDoesNotMatch_badPath() {
        Long id = 7L;
        Seite existing = new Seite("Max", LocalDate.of(2015, 5, 5), "grün", "spielen", "Pommes", "Pilot");
        existing.setId(id);
        existing.setUserId(20L);

        when(repo.findById(id)).thenReturn(Optional.of(existing));

        ResponseStatusException ex = assertThrows(ResponseStatusException.class,
                () -> seiteService.delete(id, 1L));

        assertThat(ex.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
    }
}
