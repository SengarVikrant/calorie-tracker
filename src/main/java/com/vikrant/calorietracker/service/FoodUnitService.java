package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.FoodUnit;
import com.vikrant.calorietracker.repository.FoodUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodUnitService {

    @Autowired
    private FoodUnitRepository foodUnitRepository;

    public List<FoodUnit> getAllFoodUnits() {
        return foodUnitRepository.findAll();
    }

    public FoodUnit getFoodUnitById(Long id) {
        return foodUnitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food Unit not found!"));
    }

    public FoodUnit saveFoodUnit(FoodUnit foodUnit) {
        return foodUnitRepository.save(foodUnit);
    }

    public void deleteFoodUnitById(Long id) {
        FoodUnit foodUnit = getFoodUnitById(id);
        foodUnitRepository.delete(foodUnit);
    }
}
