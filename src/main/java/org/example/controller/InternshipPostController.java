package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.InternshipPostDTO;
import org.example.services.InternshipPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/company/posts")

public class InternshipPostController {

    private final  InternshipPostService internshipPostService;

    @PostMapping
    public ResponseEntity<InternshipPostDTO> createPost(@RequestBody InternshipPostDTO dto, @RequestParam Long userId) {
        InternshipPostDTO created = internshipPostService.createPost(dto, userId);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<InternshipPostDTO>> getAllPosts() {
        return ResponseEntity.ok(internshipPostService.getAllPosts());
    }

    @GetMapping("/search")
    public ResponseEntity<List<InternshipPostDTO>> searchPosts(@RequestParam String keyword) {
        return ResponseEntity.ok(internshipPostService.searchPosts(keyword));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<InternshipPostDTO>> filterPosts(@RequestParam(required = false) String location,
                                                              @RequestParam(required = false) String duration) {
        return ResponseEntity.ok(internshipPostService.filterPosts(location, duration));
    }

    @GetMapping("search/{id}")
    public ResponseEntity<InternshipPostDTO> SearchById(@PathVariable Long id){
    InternshipPostDTO internshipPostDTO=internshipPostService.searchByIdPsosts(id);
    return ResponseEntity.ok(internshipPostDTO);
    }
} 