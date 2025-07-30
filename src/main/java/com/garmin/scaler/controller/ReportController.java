package com.garmin.scaler.controller;

import com.garmin.scaler.domain.DailyActivity;
import com.garmin.scaler.persistency.ActivityRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller("/report")
public class ReportController {

    private final ActivityRepository repository;

    public ReportController(ActivityRepository repository) {
        this.repository = repository;
    }

    @Get
    public Map<String, Object> getDailyReport(@QueryValue LocalDateTime startTime,
                                              @QueryValue LocalDateTime endTime) {
        List<DailyActivity> activities = repository.findByStartTimeGMTBetween(startTime, endTime);

        if (activities.isEmpty()) {
            return Map.of("message", "No data found between " + startTime + " and " + endTime);
        }

        int totalSteps = activities.stream().mapToInt(DailyActivity::getSteps).sum();
        double totalDistance = activities.stream().mapToDouble(DailyActivity::getDistance).sum();
        double totalCalories = activities.stream().mapToDouble(DailyActivity::getCalories).sum();

        return Map.of(
                "start", startTime,
                "end", endTime,
                "activities_count", activities.size(),
                "total_steps", totalSteps,
                "total_distance", totalDistance,
                "total_calories", totalCalories,
                "message", "Summary generated successfully"
        );
    }
}
