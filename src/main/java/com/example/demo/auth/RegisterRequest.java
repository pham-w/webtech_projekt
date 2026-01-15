package com.example.demo.auth;

public record RegisterRequest(
        String email,
        String password,
        String name
) {}
