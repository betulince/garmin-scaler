package com.garmin.scaler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable
public class DailyActivityDto {

    private Long activityId;
    private String activityName;
    private ActivityTypeDto activityType;
    private String startTimeLocal;
    private double distance;
    private double duration;
    private double calories;
    private int steps;
    private double averageHR;
    private double maxHR;
    private double avgCadence;
    private double maxCadence;
    private String locationName;

    public DailyActivityDto() {
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public ActivityTypeDto getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityTypeDto activityType) {
        this.activityType = activityType;
    }

    public String getStartTimeLocal() {
        return startTimeLocal;
    }

    public void setStartTimeLocal(String startTimeLocal) {
        this.startTimeLocal = startTimeLocal;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getAverageHR() {
        return averageHR;
    }

    public void setAverageHR(double averageHR) {
        this.averageHR = averageHR;
    }

    public double getMaxHR() {
        return maxHR;
    }

    public void setMaxHR(double maxHR) {
        this.maxHR = maxHR;
    }

    public double getAvgCadence() {
        return avgCadence;
    }

    public void setAvgCadence(double avgCadence) {
        this.avgCadence = avgCadence;
    }

    public double getMaxCadence() {
        return maxCadence;
    }

    public void setMaxCadence(double maxCadence) {
        this.maxCadence = maxCadence;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Introspected
    @Serdeable
    public static class ActivityTypeDto {
        private Integer typeId;
        private String typeKey;

        public Integer getTypeId() {
            return typeId;
        }

        public void setTypeId(Integer typeId) {
            this.typeId = typeId;
        }

        public String getTypeKey() {
            return typeKey;
        }

        public void setTypeKey(String typeKey) {
            this.typeKey = typeKey;
        }
    }

}

