package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Table(name = "daily_summary")
@Entity
public class DailySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate summaryDate;
    private double caloriesIn;
    private double caloriesBurned;
    private double netCalorieBalance;
    private boolean deficitAchieved;
    private int waterIntakeMl;
    private boolean waterGoalMet;
    private int totalExerciseMins;
    private Double weightKg;
}
