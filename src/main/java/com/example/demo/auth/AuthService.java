package com.example.demo.auth;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void register(String email, String password, String name) {
        String norm = email.toLowerCase().trim();

        if (userRepository.existsByEmail(norm)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }

        User user = new User();
        user.setEmail(norm);
        user.setPasswordHash(encoder.encode(password));
        user.setName(name);

        userRepository.save(user);
    }

    public User login(String email, String password) {
        String norm = email.toLowerCase().trim();

        User user = userRepository.findByEmail(norm)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login"));

        if (!encoder.matches(password, user.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid login");
        }

        return user;
    }
}
