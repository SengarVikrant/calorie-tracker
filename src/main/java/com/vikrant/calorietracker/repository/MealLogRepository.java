package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.MealLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealLogRepository extends JpaRepository<MealLog, Long> {
}
