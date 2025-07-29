package com.garmin.scaler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Serdeable
@Entity
@Table(name = "activity")
public class DailyActivity {

    @Id
    private Long activityId;
    private String activityName;

    @Column(name = "activity_type_id")
    private Integer activityTypeId;

    @Column(name = "activity_type_key")
    private String activityTypeKey;

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

    public Integer getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Integer activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeKey() {
        return activityTypeKey;
    }

    public void setActivityTypeKey(String activityTypeKey) {
        this.activityTypeKey = activityTypeKey;
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
}
