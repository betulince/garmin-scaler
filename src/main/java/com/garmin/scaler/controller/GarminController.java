package com.garmin.scaler.controller;

import com.garmin.scaler.model.DailyActivity;
import com.garmin.scaler.model.DailyActivityDto;
import com.garmin.scaler.service.ActivityService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.HttpResponse;

import jakarta.inject.Inject;

import java.util.Map;

@Controller("/activities")
public class GarminController {

    @Inject
    ActivityService activityService;

    @Post(value = "/upload", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> uploadActivityJson(@Body DailyActivityDto activityDto) {
        try {
            DailyActivity saved = activityService.saveOrUpdateActivity(activityDto);
            return HttpResponse.ok(Map.of(
                    "status", "success",
                    "activityId", saved.getActivityId()
            ));
        } catch (Exception e) {
            return HttpResponse.serverError(Map.of(
                    "error", e.getMessage()
            ));
        }
    }

}
