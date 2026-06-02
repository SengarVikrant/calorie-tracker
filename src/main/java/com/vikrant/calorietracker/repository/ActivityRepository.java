package com.vikrant.calorietracker.repository;

import com.vikrant.calorietracker.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
