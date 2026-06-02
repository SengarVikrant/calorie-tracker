package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.WeightLog;
import com.vikrant.calorietracker.repository.WeightLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeightLogService {

    @Autowired
    private WeightLogRepository weightLogRepository;

    public List<WeightLog> getAllWeightLogs() {
        return weightLogRepository.findAll();
    }

    public WeightLog saveWeightLog(WeightLog weightLog) {
        return weightLogRepository.save(weightLog);
    }

    public WeightLog getWeightLogById(Long id) {
        return weightLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WeightLog not found with id: " + id));
    }

    public void deleteWeightLog(Long id) {
        WeightLog weightLog = weightLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WeightLog not found with id: " + id));
        weightLogRepository.delete(weightLog);
    }
}
