package com.garmin.scaler.controller;

import com.garmin.scaler.domain.DailyActivity;
import com.garmin.scaler.domain.DailyActivityDto;
import com.garmin.scaler.persistency.ActivityRepository;
import com.garmin.scaler.service.ActivityService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Controller("/activities")
public class GarminController {

    @Inject
    MeterRegistry meterRegistry;

    @Inject
    ActivityService activityService;

    @Inject
    ActivityRepository activityRepository;

    @Post(value = "/upload", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Map<String, Object>> uploadActivityJson(@Body DailyActivityDto activityDto) {
        try {
            DailyActivity saved = activityService.saveOrUpdateActivity(activityDto);
            meterRegistry.counter("activities.uploaded").increment();
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

    @Get("/activity")
    public HttpResponse<?> getActivity(@QueryValue String activityName,
                                       @QueryValue LocalDateTime activityDate) {
        Optional<DailyActivity> existingOpt =
                activityRepository.findByActivityNameAndStartTimeGMT(activityName, activityDate);

        if (existingOpt.isPresent()) {
            return HttpResponse.ok(existingOpt.get());
        } else {
            return HttpResponse.notFound(Map.of(
                    "status", "Not found",
                    "message", "No activity found with the given name and date"
            ));
        }
    }

}
