package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserDTO;
import org.example.services.AuthService;
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

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody Map<String, String> request) {
        UserDTO userDTO = UserDTO.builder()
                .username(request.get("username"))
                .role(request.get("role"))
                .build();
        UserDTO created = authService.register(userDTO, request.get("password"));
        return ResponseEntity.ok(created);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String token = authService.authenticate(request.get("username"), request.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }
} 