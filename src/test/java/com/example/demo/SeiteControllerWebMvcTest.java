package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SeiteController.class)
@AutoConfigureMockMvc(addFilters = false)
class SeiteControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SeiteService seiteService;

    @Test
    void returnsSavedSeite() throws Exception {
        Seite input = new Seite("Angi", LocalDate.of(2005,1,1), "Blau", "Karate", "Pizza", "Dev");
        input.setUserId(1L);

        Seite saved = new Seite("Angi", LocalDate.of(2005,1,1), "Blau", "Karate", "Pizza", "Dev");
        saved.setUserId(1L);
        saved.setId(10L);

        when(seiteService.save(any(Seite.class))).thenReturn(saved);

        mockMvc.perform(post("/seite")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.name").value("Angi"))
                .andExpect(jsonPath("$.userId").value(1));
    }


    @Test
    void returnsBadRequest() throws Exception {
        Seite input = new Seite("NoUser", LocalDate.of(2000,2,2), "Rot", "Fußball", "Sushi", "Student");
        // intentionally not setting userId

        mockMvc.perform(post("/seite")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllSeiten() throws Exception {
        Seite s1 = new Seite("Anna", LocalDate.parse("2010-01-01"), "blau", "lesen", "Pizza", "Bäcker");
        s1.setId(1L);
        s1.setUserId(5L);

        List<Seite> mockSeiten = List.of(s1);
        when(seiteService.getAllForUser(5L)).thenReturn(mockSeiten);

        mockMvc.perform(get("/seite").param("userId", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Anna"));
    }

    @Test
    void testCreateSeite() throws Exception {
        String json = """
            { "name":"Anna", "hobby":"Karate", "userId":1 }
        """;

        mockMvc.perform(post("/seite")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}

