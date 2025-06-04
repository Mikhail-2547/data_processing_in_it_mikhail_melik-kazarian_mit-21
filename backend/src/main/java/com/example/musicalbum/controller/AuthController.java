package com.example.musicalbum.controller;

import com.example.musicalbum.model.User;
import com.example.musicalbum.repository.UserRepository;
import com.example.musicalbum.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    // Registration
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("This user already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.info("[ SUCCESS ] :: User is registered: {}", user.getUsername());
        return ResponseEntity.ok("User was successfully created");
    }

    // Authorization and giving JWT
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            String token = jwtService.generateToken(user.getUsername());
            log.info("[ SUCCESS ] :: User: {}, token is given", user.getUsername());
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            log.warn("[ FAILURE ] :: failed to login (maybe next time) to: {}", user.getUsername());
            return ResponseEntity.status(401).body("Wrong login or password");
        }
    }
}
