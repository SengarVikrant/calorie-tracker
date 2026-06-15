package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.WeightLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WeightLogRepository extends JpaRepository<WeightLog, Long> {
    @Query("SELECT w FROM WeightLog w WHERE DATE(w.loggedAt) = :date ORDER BY w.loggedAt DESC")
    List<WeightLog> findByDate(@Param("date") LocalDate date);
}
