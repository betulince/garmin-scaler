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
            existing.setStartTimeGMT(entity.getStartTimeGMT());
            existing.setEndTimeGMT(entity.getEndTimeGMT());
            existing.setDistance(entity.getDistance());
            existing.setDuration(entity.getDuration());
            existing.setCalories(entity.getCalories());
            existing.setSteps(entity.getSteps());
            existing.setAverageHR(entity.getAverageHR());
            existing.setMaxHR(entity.getMaxHR());
            existing.setTrainingEffectLabel(entity.getTrainingEffectLabel());
            existing.setVO2MaxValue(entity.getVO2MaxValue());
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

        if (dto.getStartTimeGMT() != null && dto.getEndTimeGMT() != null) {
            entity.setStartTimeGMT(LocalDateTime.parse(dto.getStartTimeGMT(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            entity.setEndTimeGMT(LocalDateTime.parse(dto.getEndTimeGMT(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }

        entity.setDistance(dto.getDistance());
        entity.setDuration(dto.getDuration());
        entity.setCalories(dto.getCalories());
        entity.setSteps(dto.getSteps());
        entity.setAverageHR(dto.getAverageHR());
        entity.setMaxHR(dto.getMaxHR());
        entity.setTrainingEffectLabel(dto.getTrainingEffectLabel());
        entity.setVO2MaxValue(dto.getVO2MaxValue());
        entity.setLocationName(dto.getLocationName());

        return entity;
    }


}
