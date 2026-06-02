package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
