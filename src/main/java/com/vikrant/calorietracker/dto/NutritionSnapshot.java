package com.vikrant.calorietracker.dto;

import lombok.Data;
import lombok.Getter;

@Getter
public class NutritionSnapshot {
    private double calories;
    private double protein;
    private double carbs;
    private double fat;
    private double fiber;

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public void setCalories(double value) { this.calories = round(value); }
    public void setProtein(double value)  { this.protein  = round(value); }
    public void setCarbs(double value)    { this.carbs    = round(value); }
    public void setFat(double value)      { this.fat      = round(value); }
    public void setFiber(double value)    { this.fiber    = round(value); }
}
