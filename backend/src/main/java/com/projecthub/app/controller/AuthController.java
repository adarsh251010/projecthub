package com.projecthub.app.controller;

import com.projecthub.app.model.User;
import com.projecthub.app.security.JwtUtil;
import com.projecthub.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired private AuthService authService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwt;

    public static class RegisterReq {
        @NotBlank public String name;
        @Email public String email;
        @NotBlank public String password;
    }
    public static class LoginReq {
        @Email public String email;
        @NotBlank public String password;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterReq req){
        User u = authService.register(req.name, req.email, req.password);
        String token = jwt.generateToken(u.getEmail());
        return ResponseEntity.ok(Map.of("token", token, "user", Map.of("id", u.getId(), "name", u.getName(), "email", u.getEmail())));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginReq req){
        return authService.findByEmail(req.email)
                .filter(u -> passwordEncoder.matches(req.password, u.getPassword()))
                .map(u -> ResponseEntity.ok(Map.of("token", jwt.generateToken(u.getEmail()))))
                .orElse(ResponseEntity.status(401).body(Map.of("error", "Invalid credentials")));
    }
}
