package com.example.demo.auth;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void register(String email, String password, String name) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setEmail(email.toLowerCase().trim());
        user.setPasswordHash(encoder.encode(password));
        user.setName(name);

        userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email.toLowerCase().trim())
                .orElseThrow(() -> new RuntimeException("Invalid login"));

        if (!encoder.matches(password, user.getPasswordHash())) {
            throw new RuntimeException("Invalid login");
        }

        return user;
    }
}
