package com.example.demo.auth;

import com.example.demo.user.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest req) {
        authService.register(req.email(), req.password(), req.name());
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {
        User user = authService.login(req.email(), req.password());
        return new AuthResponse(user.getId(), user.getEmail(), user.getName());
    }
}
