package com.garmin.scaler.domain;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Introspected
@Serdeable
public class DailyActivityDto {

    private Long activityId;
    private String activityName;
    private ActivityTypeDto activityType;
    private String startTimeGMT;
    private String endTimeGMT;
    private double distance;
    private double duration;
    private double calories;
    private int steps;
    private double averageHR;
    private double maxHR;
    private String trainingEffectLabel;
    private double vO2MaxValue;
    private String locationName;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Introspected
    @Serdeable
    public static class ActivityTypeDto {
        private Integer typeId;
        private String typeKey;
    }
}
