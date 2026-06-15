package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.WaterLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface WaterLogRepository extends JpaRepository<WaterLog, Long> {
    @Query("SELECT SUM(w.amountInMl) FROM WaterLog w WHERE DATE(w.loggedAt) =:date")
    Double sumWaterByDate(@Param("date") LocalDate date);
}
