package com.example.demo.auth;

public record AuthResponse(
        Long id,
        String email,
        String name
) {}
