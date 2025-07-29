package com.garmin.scaler.service;

import com.garmin.scaler.domain.DailyActivity;
import com.garmin.scaler.domain.DailyActivityDto;
import com.garmin.scaler.persistency.ActivityRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Singleton
public class ActivityService {

    @Inject
    ActivityRepository activityRepository;

    @Transactional
    public DailyActivity saveOrUpdateActivity(DailyActivityDto dto) {
        DailyActivity entity = mapDtoToEntity(dto);

        Optional<DailyActivity> existingOpt = activityRepository.findByActivityId(entity.getActivityId());
        if (existingOpt.isPresent()) {
            DailyActivity existing = existingOpt.get();

            existing.setActivityName(entity.getActivityName());
            existing.setActivityTypeId(entity.getActivityTypeId());
            existing.setActivityTypeKey(entity.getActivityTypeKey());
            existing.setStartTimeLocal(entity.getStartTimeLocal());
            existing.setDistance(entity.getDistance());
            existing.setDuration(entity.getDuration());
            existing.setCalories(entity.getCalories());
            existing.setSteps(entity.getSteps());
            existing.setAverageHR(entity.getAverageHR());
            existing.setMaxHR(entity.getMaxHR());
            existing.setAvgCadence(entity.getAvgCadence());
            existing.setMaxCadence(entity.getMaxCadence());
            existing.setLocationName(entity.getLocationName());

            return activityRepository.update(existing);
        } else {
            return activityRepository.save(entity);
        }
    }

    public DailyActivity mapDtoToEntity(DailyActivityDto dto) {
        DailyActivity entity = new DailyActivity();

        entity.setActivityId(dto.getActivityId());
        entity.setActivityName(dto.getActivityName());

        if (dto.getActivityType() != null) {
            entity.setActivityTypeId(dto.getActivityType().getTypeId());
            entity.setActivityTypeKey(dto.getActivityType().getTypeKey());
        } else {
            entity.setActivityTypeId(null);
            entity.setActivityTypeKey(null);
        }

        if (dto.getStartTimeLocal() != null) {
            entity.setStartTimeLocal(String.valueOf(LocalDateTime.parse(dto.getStartTimeLocal(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        }

        entity.setDistance(dto.getDistance());
        entity.setDuration(dto.getDuration());
        entity.setCalories(dto.getCalories());
        entity.setSteps(dto.getSteps());
        entity.setAverageHR(dto.getAverageHR());
        entity.setMaxHR(dto.getMaxHR());
        entity.setAvgCadence(dto.getAvgCadence());
        entity.setMaxCadence(dto.getMaxCadence());
        entity.setLocationName(dto.getLocationName());

        return entity;
    }


}
