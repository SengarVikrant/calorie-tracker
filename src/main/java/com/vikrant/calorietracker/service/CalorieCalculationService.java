package com.vikrant.calorietracker.service;


import com.vikrant.calorietracker.dto.NutritionSnapshot;
import com.vikrant.calorietracker.entity.Food;
import com.vikrant.calorietracker.entity.FoodUnit;
import com.vikrant.calorietracker.repository.FoodRepository;
import com.vikrant.calorietracker.repository.FoodUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalorieCalculationService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodUnitRepository foodUnitRepository;


    public NutritionSnapshot calculateNutrition(Long food_id, Long unit_id, double quantity) {
        Food food = foodRepository.findById(food_id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + food_id));

        FoodUnit foodUnit = foodUnitRepository
                .findByFoodIdAndUnitId(food_id, unit_id)
                .orElseThrow(() -> new RuntimeException("FoodUnit not found"));

        double volume;
        double weight = 0;
        double calories;
        double protein;
        double carbs;
        double fat;
        double fiber;

        if (foodUnit.getAmountInMl() != null){
            volume =  foodUnit.getAmountInMl() * quantity;
            weight = volume * food.getDensity();
        }else{
            weight = quantity * foodUnit.getAmountInGrams();


        }
        calories = (weight/100) * food.getCaloriesPer100g();
        protein = (weight/100) * food.getProteinPer100g();
        carbs = (weight/100) * food.getCarbsPer100g();
        fat = (weight/100) * food.getFatPer100g();
        fiber = (weight/100) * food.getFiberPer100g();

        NutritionSnapshot snapshot = new NutritionSnapshot();
        snapshot.setCalories(calories);
        snapshot.setProtein(protein);
        snapshot.setCarbs(carbs);
        snapshot.setFiber(fiber);
        snapshot.setFat(fat);

        return snapshot;
    }
}
