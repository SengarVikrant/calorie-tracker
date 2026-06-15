package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.DailySummary;
import com.vikrant.calorietracker.service.DailySummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/summary")
public class DailySummaryController {

    @Autowired
    private DailySummaryService dailySummaryService;

    @GetMapping("/today")
    public DailySummary getTodaySummary() {
        return dailySummaryService.getSummaryForDate(LocalDate.now());
    }

    @GetMapping("/{date}")
    public DailySummary getSummaryByDate(@PathVariable LocalDate date) {
        return dailySummaryService.getSummaryForDate(date);

    }

}
