package com.vikrant.calorietracker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "unit")
@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private UnitType unitType;
    private Double amountInMl;
}
