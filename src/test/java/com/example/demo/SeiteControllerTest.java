package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class SeiteControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SeiteService seiteService;

    private SeiteController controller;

    @BeforeEach
    void setup() {
        controller = new SeiteController();
        // injiziere das Mock-Objekt in das private Feld 'service' des Controllers
        ReflectionTestUtils.setField(controller, "service", seiteService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Gibt den passenden Eintrag des Benutzers zurück")
    void shouldReturnUserPages() throws Exception {
        Seite s1 = new Seite("Anna", LocalDate.parse("2010-01-01"), "blau", "lesen", "Pizza", "Bäcker");
        s1.setId(1L);
        s1.setUserId(5L);

        Seite s2 = new Seite("Ben", LocalDate.parse("2011-03-10"), "lila", "backen", "Nudeln", "Designer");
        s2.setId(2L);
        s2.setUserId(5L);

        List<Seite> mockSeiten = List.of(s1, s2);

        when(seiteService.getAllForUser(5L)).thenReturn(mockSeiten);

        mockMvc.perform(get("/seite?userId=5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Anna"))
                .andExpect(jsonPath("$[1].favFood").value("Nudeln"));
    }
}
