package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.WaterLog;
import com.vikrant.calorietracker.service.WaterLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/water-logs")
public class WaterLogController {

    @Autowired
    private WaterLogService waterLogService;

    @GetMapping
    public List<WaterLog> getAllWaterLogs() {
        return waterLogService.getAllWaterLogs();
    }

    @GetMapping("/{id}")
    public WaterLog getWaterLogById(@PathVariable Long id) {
        return waterLogService.getWaterLogById(id);
    }

    @PostMapping
    public WaterLog addWaterLog(@RequestBody WaterLog waterLog) {
        return waterLogService.saveWaterLog(waterLog);
    }

    @DeleteMapping("/{id}")
    public String deleteWaterLogById(@PathVariable Long id) {
        waterLogService.deleteWaterLog(id);
        return "WaterLog has been deleted";
    }
}
