package com.invoice.gateway;

import com.invoice.users.ProfileDTO;
import com.invoice.users.ProfileExternalAPI;
import com.invoice.users.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileExternalAPI profileExternalAPI;

    public ProfileController(ProfileExternalAPI profileExternalAPI) {
        this.profileExternalAPI = profileExternalAPI;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(profileExternalAPI.getProfileById(id));
    }

    @PostMapping
    public ResponseEntity<ProfileDTO> save(@RequestBody @Valid ProfileDTO profileDTO){
        return ResponseEntity.ok(profileExternalAPI.saveProfile(profileDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProfileDTO> update(@PathVariable("id") Long id, @RequestBody @Valid ProfileDTO profileDTO){
        return ResponseEntity.ok(profileExternalAPI.updateProfile(id, profileDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProfileDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(profileExternalAPI.deleteProfile(id));
    }
}
