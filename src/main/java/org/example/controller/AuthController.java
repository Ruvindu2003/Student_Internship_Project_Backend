package org.example.controller;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.enums.Role;
import org.example.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody Map<String, String> request) {
        UserDTO userDTO = UserDTO.builder()
                .username(request.get("username"))
                .role(Role.valueOf(request.get("role")))
                .build();
        UserDTO created = authService.register(userDTO, request.get("password"));
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        log.info("Login attempt for username: {}", request.get("username"));
        try {
            String token = authService.authenticate(request.get("username"), request.get("password"));
            log.info("Login successful for username: {}", request.get("username"));
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {
            log.error("Login failed for username: {}", request.get("username"), e);
            throw e;
        }
    }
    }
