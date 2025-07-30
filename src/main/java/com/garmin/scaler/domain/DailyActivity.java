package com.garmin.scaler.domain;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
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

    private LocalDateTime startTimeGMT;
    private LocalDateTime endTimeGMT;
    private double distance;
    private double duration;
    private double calories;
    private int steps;
    private double averageHR;
    private double maxHR;
    private String trainingEffectLabel;
    private double vO2MaxValue;
    private String locationName;
}
