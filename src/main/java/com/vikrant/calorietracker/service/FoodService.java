package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.Food;
import com.vikrant.calorietracker.entity.Unit;
import com.vikrant.calorietracker.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }
    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
    }
    public void deleteFood(Long id){
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Food not found with id: " + id));
        foodRepository.delete(food);
    }

}
