package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "food_unit")
public class FoodUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    // Used for SOLID and COUNTABLE foods
    private Double amountInGrams;

    // Used for LIQUID foods
    private Double amountInMl;

    private boolean defaultUnit;
}