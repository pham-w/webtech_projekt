package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DbDebugController {

    private final JdbcTemplate jdbc;

    public DbDebugController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/dbinfo")
    public Map<String, Object> dbinfo() {
        return jdbc.queryForMap("""
            SELECT
              current_user as user,
              current_database() as db,
              current_schema() as schema,
              current_setting('search_path') as search_path
        """);
    }
}
