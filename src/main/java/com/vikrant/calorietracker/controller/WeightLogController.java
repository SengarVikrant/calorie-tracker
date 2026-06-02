package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.WeightLog;
import com.vikrant.calorietracker.service.WeightLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weight-logs")
public class WeightLogController {

    @Autowired
    private WeightLogService weightLogService;

    @GetMapping
    public List<WeightLog> getAllWeightLogs() {
        return weightLogService.getAllWeightLogs();
    }

    @GetMapping("/{id}")
    public WeightLog getWeightLogById(@PathVariable Long id) {
        return weightLogService.getWeightLogById(id);
    }

    @PostMapping
    public WeightLog addWeightLog(@RequestBody WeightLog weightLog) {
        return weightLogService.saveWeightLog(weightLog);
    }

    @DeleteMapping("/{id}")
    public String deleteWeightLogById(@PathVariable Long id) {
        weightLogService.deleteWeightLog(id);
        return "WeightLog has been deleted";
    }
}
