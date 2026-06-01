package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "food")
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;

    // Nutrition per 100g
    private double caloriesPer100g;
    private double proteinPer100g;
    private double carbsPer100g;
    private double fatPer100g;
    private double fiberPer100g;

    private Double density;

    @ManyToOne
    @JoinColumn(name = "default_unit_id")
    private Unit defaultUnit;

    // Flags
    private boolean isVerified; // manually checked nutrition?
    private boolean isCustom;   // user-added or preloaded?

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
