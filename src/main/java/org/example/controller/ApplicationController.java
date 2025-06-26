package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.ApplicationDTO;

import org.example.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/student/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationDTO> apply(@RequestBody Map<String, String> request) {
        Long studentId = Long.valueOf(request.get("studentId"));
        Long postId = Long.valueOf(request.get("postId"));
        String resumeLink = request.get("resumeLink");
        ApplicationDTO application = applicationService.apply(studentId, postId, resumeLink);
        return ResponseEntity.ok(application);
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> getApplications(@RequestParam Long studentId) {
        return ResponseEntity.ok(applicationService.getApplicationsByStudent(studentId));
    }
} 