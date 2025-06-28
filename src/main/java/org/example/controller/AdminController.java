package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.InternshipPostDTO;
import org.example.dto.UserDTO;
import org.example.services.AdminService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(adminService.getAllUsers());
    }

    @GetMapping("/posts")
    public ResponseEntity<List<InternshipPostDTO>> getAllPosts() {
        return ResponseEntity.ok(adminService.getAllPosts());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Long id) {
        boolean deleteUser = adminService.deleteUser(id);
        return ResponseEntity.ok(deleteUser);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        adminService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
} 