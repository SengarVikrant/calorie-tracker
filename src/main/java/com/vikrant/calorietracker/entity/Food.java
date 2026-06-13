package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "food", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    @Enumerated(EnumType.STRING)
    private FoodState foodState;

    // Nutrition per 100g
    private double caloriesPer100g;
    private double proteinPer100g;
    private double carbsPer100g;
    private double fatPer100g;
    private double fiberPer100g;

    private Double density;


    // Flags
    private boolean verified; // manually checked nutrition?
    private boolean custom;   // user-added or preloaded?

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
