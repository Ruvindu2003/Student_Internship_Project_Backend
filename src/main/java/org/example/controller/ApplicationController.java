package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Application;
import org.example.services.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/application")
@RestController

public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping("/get-All")
    ResponseEntity<List<Application>> getAll() {
        List<Application> applications = applicationService.getAll();
        return ResponseEntity.ok(applications);
    }


    @PostMapping("/add-application")
    ResponseEntity<?> addApplication(@RequestBody Application application) {

        boolean save = applicationService.addApplication(application);

        return ResponseEntity.ok(save);


    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> searchById(@PathVariable Long id) {
        Application application = applicationService.SearchById(id);

        if (application == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(application);
    }


    @PutMapping("/update")

    public ResponseEntity<String> updateApplication(@RequestBody Application application) {
        boolean update = applicationService.updateApplication(application);
        if (update) {
            return ResponseEntity.ok("Application updated successfully");
        }
        return ResponseEntity.badRequest().body("Failed to update application");
    }




    public  ResponseEntity<Boolean> deleteApplication(@PathVariable Long id){

        boolean delete= applicationService.deleteApplication(id);

        if (delete){

          return   ResponseEntity.ok(delete);
        }

        return ResponseEntity.badRequest().build();

    }

}










