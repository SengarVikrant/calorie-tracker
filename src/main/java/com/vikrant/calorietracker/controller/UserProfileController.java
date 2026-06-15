package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.UserProfile;
import com.vikrant.calorietracker.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{id}")
    public UserProfile getUserProfileById(@PathVariable Long id) {
        return userProfileService.getUserProfileById(id);
    }

    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
        return userProfileService.saveProfile(userProfile);
    }


    @PutMapping("/{id}")
    public UserProfile updateProfile(@PathVariable Long id, @RequestBody UserProfile userProfile) {
        return userProfileService.updateProfile(id, userProfile);
    }
}
