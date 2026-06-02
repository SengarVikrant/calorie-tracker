package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.Unit;
import com.vikrant.calorietracker.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping
    public List<Unit> getAllUnits() {
        return unitService.getAllUnits();
    }

    @GetMapping("/{id}")
    public Unit getUnitById(@PathVariable Long id) {
        return unitService.getUnitById(id);
    }

    @PostMapping
    public Unit createUnit(@RequestBody Unit unit) {
        return unitService.createUnit(unit);
    }

    @DeleteMapping("/{id}")
    public String deleteUnitById(@PathVariable Long id) {
        unitService.deleteUnit(id);
        return "Unit deleted successfully";
    }





}
