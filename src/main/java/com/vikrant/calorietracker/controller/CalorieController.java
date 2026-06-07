package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.service.CalorieCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calorie")
public class CalorieController {



    @Autowired
    private CalorieCalculationService calorieCalculationService;

    @GetMapping("/calculate")
    public double calculateCalorie(@RequestParam Long foodId, @RequestParam Long unitId, @RequestParam double quantity){
        return calorieCalculationService.calculateCalorie(foodId, unitId, quantity);

    }
}
