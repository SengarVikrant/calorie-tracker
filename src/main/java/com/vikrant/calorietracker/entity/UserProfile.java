package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "user_profile")
@Entity
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int heightCm;
    private double weightKg;
    private double goalWeightKg;
    private int dailyCaloriesGoal;
    private int dailyDeficitGoal;
    private int dailyWaterGoalMl;
    private ActivityLevel activityLevel;
    private double bmr;
    private Gender gender;
    private LocalDateTime createdAt;
}
