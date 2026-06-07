package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.FoodUnit;
import com.vikrant.calorietracker.service.FoodUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-unit")
public class FoodUnitController {

    @Autowired
    private FoodUnitService foodUnitService;

    @GetMapping
    public List<FoodUnit> getAllFoodUnits() {
        return foodUnitService.getAllFoodUnits();
    }

    @GetMapping("/{id}")
    public FoodUnit getFoodUnitById(@PathVariable Long id) {
        return foodUnitService.getFoodUnitById(id);
    }

    @PostMapping
    public FoodUnit addFoodUnit(@RequestBody FoodUnit foodUnit){
        return foodUnitService.saveFoodUnit(foodUnit);
    }

    @DeleteMapping("/{id}")
    public String deleteFoodUnitById(@PathVariable Long id) {
        foodUnitService.deleteFoodUnitById(id);
        return "Food Unit deleted successfully";
    }

}
