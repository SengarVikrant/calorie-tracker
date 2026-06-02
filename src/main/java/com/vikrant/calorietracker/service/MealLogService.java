package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.MealLog;
import com.vikrant.calorietracker.repository.MealLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealLogService {

    @Autowired
    private MealLogRepository mealLogRepository;

    public List<MealLog> getAllMealLogs() {
        return mealLogRepository.findAll();
    }

    public MealLog saveMealLog(MealLog mealLog) {
        return mealLogRepository.save(mealLog);
    }

    public MealLog getMealLogById(Long id) {
        return mealLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MealLog not found with id: " + id));
    }

    public void deleteMealLog(Long id) {
        MealLog mealLog = mealLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MealLog not found with id: " + id));
        mealLogRepository.delete(mealLog);
    }
}
