package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.dto.NutritionSnapshot;
import com.vikrant.calorietracker.entity.MealItem;
import com.vikrant.calorietracker.repository.MealItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealItemService {

    @Autowired
    private CalorieCalculationService  calorieCalculationService;

    @Autowired
    private MealItemRepository mealItemRepository;

    public MealItem getMealItemById(Long id){
        return  mealItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal Item Not Found"));
    }

    public List<MealItem> getAllMealItem(){
        return mealItemRepository.findAll();
    }

    public void deleteMealItem(Long id){
        MealItem mealItem = getMealItemById(id);
        mealItemRepository.delete(mealItem);
    }

    public MealItem saveMealItem(MealItem mealItem) {

        Long foodId = mealItem.getFood().getId();
        Long unitId = mealItem.getUnit().getId();
        double quantity = mealItem.getQuantity();


        NutritionSnapshot snapshot = calorieCalculationService.calculateNutrition(foodId, unitId, quantity);
        mealItem.setCalories(snapshot.getCalories());
        mealItem.setProtein(snapshot.getProtein());
        mealItem.setCarbs(snapshot.getCarbs());
        mealItem.setFats(snapshot.getFat());
        mealItem.setFiber(snapshot.getFiber());

        return mealItemRepository.save(mealItem);

    }
}