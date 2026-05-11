package com.ettaleby.mbarek.examjeesdia.web;

import com.ettaleby.mbarek.examjeesdia.dto.LoginRequest;
import com.ettaleby.mbarek.examjeesdia.dto.LoginResponse;
import com.ettaleby.mbarek.examjeesdia.entities.User;
import com.ettaleby.mbarek.examjeesdia.repositories.UserRepository;
import com.ettaleby.mbarek.examjeesdia.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepo.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Identifiants invalides"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Identifiants invalides");
        }

        String token = jwtUtils.generateToken(user.getUsername(), user.getRole().name());
        return ResponseEntity.ok(LoginResponse.builder()
                .token(token)
                .role(user.getRole().name())
                .build());
    }
}