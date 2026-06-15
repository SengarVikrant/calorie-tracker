package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.MealItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface MealItemRepository extends JpaRepository<MealItem, Long> {
    @Query("SELECT SUM(m.calories) FROM MealItem m WHERE DATE(m.mealLog.consumedAt) = :date")
    Double sumCaloriesByDate(@Param("date") LocalDate date);

}

