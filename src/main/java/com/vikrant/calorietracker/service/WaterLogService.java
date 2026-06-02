package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.WaterLog;
import com.vikrant.calorietracker.repository.WaterLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterLogService {

    @Autowired
    private WaterLogRepository waterLogRepository;

    public List<WaterLog> getAllWaterLogs() {
        return waterLogRepository.findAll();
    }

    public WaterLog saveWaterLog(WaterLog waterLog) {
        return waterLogRepository.save(waterLog);
    }

    public WaterLog getWaterLogById(Long id) {
        return waterLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WaterLog not found with id: " + id));
    }

    public void deleteWaterLog(Long id) {
        WaterLog waterLog = waterLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WaterLog not found with id: " + id));
        waterLogRepository.delete(waterLog);
    }
}
