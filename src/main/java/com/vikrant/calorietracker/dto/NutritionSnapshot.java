package com.vikrant.calorietracker.dto;

import lombok.Data;

@Data
public class NutritionSnapshot {
    private double calories;
    private double protein;
    private double carbs;
    private double fat;
    private double fiber;

}
