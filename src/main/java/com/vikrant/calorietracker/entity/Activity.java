package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "activity")
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String name;

    private double metValue;

    private String description;

}
