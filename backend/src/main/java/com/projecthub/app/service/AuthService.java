package com.projecthub.app.service;

import com.projecthub.app.model.User;
import com.projecthub.app.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public User register(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already registered");
        }
        User u = new User(name, email, passwordEncoder.encode(password), "ROLE_USER");
        return userRepository.save(u);
    }

    public Optional<User> findByEmail(String email){ return userRepository.findByEmail(email); }
}
