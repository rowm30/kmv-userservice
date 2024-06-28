package com.kmv_userservice.kmv_userservice.controller;

import com.kmv_userservice.kmv_userservice.models.Requirement;
import com.kmv_userservice.kmv_userservice.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, allowedHeaders = "*", allowCredentials = "true")
@RestController
public class RequirementController {

    @Autowired
    private RequirementService requirementService;

    @PostMapping("/requirements")
    public ResponseEntity<Requirement> createRequirement(@RequestBody Requirement requirement) {
        Requirement savedRequirement = requirementService.saveRequirement(requirement);
        return ResponseEntity.ok(savedRequirement);
    }
}
