package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "activity_log")
@Entity
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    private int durationInMinutes;

    private LocalDateTime activityDone;

    // calories calculated using weight at time of logging
// weight not stored here — see WeightLog for history
    private double caloriesBurned;

    private String notes;


}
