package com.vikrant.calorietracker.service;


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

    public double calculateCalorie(Long food_id, Long unit_id, double quantity) {
        Food food = foodRepository.findById(food_id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + food_id));

        FoodUnit foodUnit = foodUnitRepository
                .findByFoodIdAndUnitId(food_id, unit_id)
                .orElseThrow(() -> new RuntimeException("FoodUnit not found"));

        double caloriePer100Gm = food.getCaloriesPer100g();
        double volume;
        double weight;
        double calories;

        if (foodUnit.getAmountInMl() != null){
            volume =  foodUnit.getAmountInMl() * quantity;
            weight = volume * food.getDensity();
            calories = (weight/100) * caloriePer100Gm;

        }else{
            weight = quantity * foodUnit.getAmountInGrams();
            calories = (weight/100) * caloriePer100Gm;

        }

        return calories;
    }
}
