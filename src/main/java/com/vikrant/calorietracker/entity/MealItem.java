package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "meal_item")
@Entity
public class MealItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "meal_log_id")
    private MealLog mealLog;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private double quantity;

    private boolean customized;

    private Double calories;
    private Double protein;
    private Double carbs;
    private Double fats;
    private Double fiber;


}
