package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.MealItem;
import com.vikrant.calorietracker.service.MealItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meal-item")
public class MealItemController {

    @Autowired
    private MealItemService mealItemService;


    @GetMapping
    public List<MealItem> getAllMealItem(){
        return mealItemService.getAllMealItem();
    }

    @GetMapping("/{id}")
    public MealItem getMealItemById(@PathVariable Long id){
        return mealItemService.getMealItemById(id);
    }

    @PostMapping
    public MealItem createMealItem(@RequestBody MealItem mealItem){
        return mealItemService.saveMealItem(mealItem);
    }

    @DeleteMapping("/{id}")
    public String deleteMealItem(@PathVariable Long id){
        mealItemService.deleteMealItem(id);
        return "Meal Item deleted successfully";

    }

}
