package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

    @Query("SELECT SUM(a.durationInMinutes) FROM ActivityLog a WHERE DATE(a.activityDone) = :date")
    Integer sumDurationByDate(@Param("date") LocalDate date);

    @Query("SELECT SUM(a.caloriesBurned) FROM ActivityLog a WHERE DATE(a.activityDone) = :date")
    Double sumCaloriesBurnedByDate(@Param("date") LocalDate date);
}
