package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.WeightLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightLogRepository extends JpaRepository<WeightLog, Long> {
}
