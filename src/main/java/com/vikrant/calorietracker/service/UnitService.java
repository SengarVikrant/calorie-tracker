package com.vikrant.calorietracker.service;

import com.vikrant.calorietracker.entity.Unit;
import com.vikrant.calorietracker.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;
    public List<Unit> getAllUnits(){
        return unitRepository.findAll();
    }

    public Unit getUnitById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found with id: " + id));
    }

    public Unit createUnit(Unit unit){
        return unitRepository.save(unit);
    }

    public void deleteUnit(Long id){
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found with id: " + id));
        unitRepository.delete(unit);
    }

}
