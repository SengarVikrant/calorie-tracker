package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.MealItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealItemRepository extends JpaRepository<MealItem, Long> {

}
