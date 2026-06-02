package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {
}
