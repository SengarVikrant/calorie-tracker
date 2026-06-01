package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "recipe_item")
@Entity
public class RecipeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    private double quantity;

}
