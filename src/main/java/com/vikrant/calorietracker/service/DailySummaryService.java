package com.vikrant.calorietracker.service;


import com.vikrant.calorietracker.entity.DailySummary;
import com.vikrant.calorietracker.entity.UserProfile;
import com.vikrant.calorietracker.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DailySummaryService {

    @Autowired
    private MealItemRepository mealItemRepository;
    @Autowired
    private ActivityLogRepository activityLogRepository;
    @Autowired
    private WaterLogRepository waterLogRepository;
    @Autowired
    private WeightLogRepository weightLogRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    public DailySummary getSummaryForDate(LocalDate date){
        Double caloriesIn = Optional.ofNullable(
                mealItemRepository.sumCaloriesByDate(date)).orElse(0.0);
        UserProfile user = userProfileRepository.findAll().get(0);
        double bmr = user.getBmr();
        double calorieBurned = Optional.ofNullable(activityLogRepository.sumCaloriesBurnedByDate(date)).orElse(0.0);
        double totalBurned = bmr + calorieBurned;
        double netCalorie = caloriesIn - totalBurned;

        boolean deficit = false;
        if(netCalorie < -user.getDailyDeficitGoal()){
            deficit = true;
        }

        double waterIn = Optional.ofNullable(waterLogRepository.sumWaterByDate(date)).orElse(0.0);
        boolean waterGoal = false;
        if (waterIn > user.getDailyWaterGoalMl()) {
            waterGoal = true;
        }

        int totalExerciseDone = Optional.ofNullable(activityLogRepository.sumDurationByDate(date)).orElse(0);

        var weightLogs = weightLogRepository.findByDate(date);
        Double weightToday = weightLogs.isEmpty() ? null : weightLogs.get(0).getWeightKg();

        DailySummary summary = new DailySummary();
        summary.setCaloriesIn(caloriesIn);
        summary.setSummaryDate(date);
        summary.setCaloriesBurned(totalBurned);
        summary.setNetCalorieBalance(netCalorie);
        summary.setDeficitAchieved(deficit);
        summary.setWaterGoalMet(waterGoal);
        summary.setWaterIntakeMl(waterIn);
        summary.setTotalExerciseMins(totalExerciseDone);
        summary.setWeightKg(weightToday);

        return summary;


    }
}
