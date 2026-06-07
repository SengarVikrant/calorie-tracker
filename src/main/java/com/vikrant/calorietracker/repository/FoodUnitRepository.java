package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.FoodUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodUnitRepository extends JpaRepository<FoodUnit, Long> {
    Optional<FoodUnit> findByFoodIdAndUnitId(Long foodId, Long unitId);
}
