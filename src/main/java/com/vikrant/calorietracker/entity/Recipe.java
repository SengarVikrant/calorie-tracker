package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "recipe")
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int defaultServing;
    private boolean isCustom;
    private boolean isVerified;
    private boolean isAiGenerated;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
