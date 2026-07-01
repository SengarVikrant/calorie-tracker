package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.Activity;
import com.vikrant.calorietracker.entity.ActivityLog;
import com.vikrant.calorietracker.entity.UserProfile;
import com.vikrant.calorietracker.entity.WeightLog;
import com.vikrant.calorietracker.repository.ActivityLogRepository;
import com.vikrant.calorietracker.repository.ActivityRepository;
import com.vikrant.calorietracker.repository.UserProfileRepository;
import com.vikrant.calorietracker.repository.WeightLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private WeightLogRepository weightLogRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public ActivityLog saveActivityLog(ActivityLog activityLog) {
        // your logic
        if (activityLog.getActivity() == null){
            return activityLogRepository.save(activityLog);
        }else{
            List<WeightLog> recentWeights = weightLogRepository.findTopByOrderByLoggedAtDesc();
            double weight;
            if(recentWeights.isEmpty()){
                UserProfile user = userProfileRepository.findAll().get(0);
                weight = user.getWeightKg();
            }else{
                weight = recentWeights.get(0).getWeightKg();
            }
            double calorie ;
            Activity activity = activityRepository.findById(
                            activityLog.getActivity().getId())
                    .orElseThrow(() -> new RuntimeException("Activity not found"));
            calorie = activity.getMetValue() * weight * (activityLog.getDurationInMinutes()/60.0);
            activityLog.setCaloriesBurned(calorie);
            return activityLogRepository.save(activityLog);


        }
    }

    public List<ActivityLog> getAllActivityLogs() {
        return activityLogRepository.findAll();
    }

    public ActivityLog getActivityLogById(Long id) {
        return activityLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ActivityLog not found with id: " + id));
    }

    public void deleteActivityLog(Long id) {
        ActivityLog activityLog = getActivityLogById(id);
        activityLogRepository.delete(activityLog);
    }
}
