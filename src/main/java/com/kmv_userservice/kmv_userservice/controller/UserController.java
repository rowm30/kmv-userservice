package com.kmv_userservice.kmv_userservice.controller;


import com.kmv_userservice.kmv_userservice.models.Locum;
import com.kmv_userservice.kmv_userservice.models.ProfessionalProfile;
import com.kmv_userservice.kmv_userservice.models.Role;
import com.kmv_userservice.kmv_userservice.repository.LocumRepository;
import com.kmv_userservice.kmv_userservice.repository.RoleRepository;
import com.kmv_userservice.kmv_userservice.service.LocumService;
import com.kmv_userservice.kmv_userservice.service.ProfessionalProfileService;
import com.kmv_userservice.kmv_userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private LocumService locumService; // This is the interface for the service class

    @Autowired
    private ProfessionalProfileService service;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProfessionalProfileService profileService;

    @Autowired
    private LocumRepository locumRepository;



    @PostMapping("/registerlocum")
    public ResponseEntity<Locum> createLocum(@RequestBody Locum locum) {
        Locum createdLocum = locumService.saveLocum(locum);
        return ResponseEntity.ok(createdLocum);
    }


    @PostMapping("/createrole")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.saveRole(role);
        return ResponseEntity.ok(createdRole);
    }


    @PostMapping("/registerprofile")
    public ResponseEntity<ProfessionalProfile> createProfile(@RequestBody ProfessionalProfile profileData) {
        Role managedRole = null;
        if (profileData.getRole() != null && profileData.getRole().getRoleId() != null) {
            managedRole = roleRepository.findById(profileData.getRole().getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
        }

        Locum managedLocum = null;
        if (profileData.getLocum() != null && profileData.getLocum().getLocum_id() != null) {
            managedLocum = locumRepository.findById(profileData.getLocum().getLocum_id())
                    .orElseThrow(() -> new RuntimeException("Locum not found"));
        }

        ProfessionalProfile profile = new ProfessionalProfile();
        profile.setRole(managedRole);
        profile.setLocum(managedLocum);
        profile.setBiography(profileData.getBiography());
        profile.setGdc_number(profileData.getGdc_number());
        profile.setReviews(profileData.getReviews());
        profile.setProfessionalReferences(profileData.getProfessionalReferences());

        ProfessionalProfile createdProfile = profileService.saveProfile(profile);
        return ResponseEntity.ok(createdProfile);
    }

    @GetMapping("/registerprofile/{id}")
    public ResponseEntity<ProfessionalProfile> getProfile(@PathVariable Integer id) {
        ProfessionalProfile profile = service.getProfileById(id);
        if (profile != null) {
            return ResponseEntity.ok(profile);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}