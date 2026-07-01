package com.vikrant.calorietracker.controller;

import com.vikrant.calorietracker.entity.ActivityLog;
import com.vikrant.calorietracker.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @GetMapping
    public List<ActivityLog> getAllActivityLog(){
        return activityLogService.getAllActivityLogs();
    }

    @GetMapping("/{id}")
    public ActivityLog getActivityLogById(@PathVariable Long id){
        return activityLogService.getActivityLogById(id);
    }

    @PostMapping
    public ActivityLog addActivityLog(@RequestBody ActivityLog activityLog){
        return activityLogService.saveActivityLog(activityLog);
    }

    @DeleteMapping("/{id}")
    public String deleteActivityLogById(@PathVariable Long id){
        activityLogService.deleteActivityLog(id);
        return "Activity log has been deleted";
    }



}
