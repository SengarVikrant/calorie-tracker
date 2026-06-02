package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.MealLog;
import com.vikrant.calorietracker.service.MealLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal-logs")
public class MealLogController {

    @Autowired
    private MealLogService mealLogService;

    @GetMapping
    public List<MealLog> getAllMealLogs() {
        return mealLogService.getAllMealLogs();
    }

    @GetMapping("/{id}")
    public MealLog getMealLogById(@PathVariable Long id) {
        return mealLogService.getMealLogById(id);
    }

    @PostMapping
    public MealLog addMealLog(@RequestBody MealLog mealLog) {
        return mealLogService.saveMealLog(mealLog);
    }

    @DeleteMapping("/{id}")
    public String deleteMealLogById(@PathVariable Long id) {
        mealLogService.deleteMealLog(id);
        return "MealLog has been deleted";
    }
}
