package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.UserProfile;
import com.vikrant.calorietracker.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public UserProfile saveProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    public UserProfile getUserProfileById(Long id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserProfile not found with id: " + id));
    }

    public UserProfile updateProfile(Long id, UserProfile updated) {
        UserProfile existing = userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        existing.setName(updated.getName());
        existing.setAge(updated.getAge());
        existing.setHeightCm(updated.getHeightCm());
        existing.setWeightKg(updated.getWeightKg());
        existing.setGoalWeightKg(updated.getGoalWeightKg());
        existing.setDailyCaloriesGoal(updated.getDailyCaloriesGoal());
        existing.setDailyDeficitGoal(updated.getDailyDeficitGoal());
        existing.setDailyWaterGoalMl(updated.getDailyWaterGoalMl());
        existing.setActivityLevel(updated.getActivityLevel());
        existing.setBmr(updated.getBmr());
        existing.setGender(updated.getGender());

        return userProfileRepository.save(existing);
    }
}
