package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "meal_log")
@Entity
public class MealLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime consumedAt;

    private String notes;
    @Enumerated(EnumType.STRING)
    private MealType mealType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
