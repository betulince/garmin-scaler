package com.garmin.scaler.persistency;

import com.garmin.scaler.domain.DailyActivity;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface ActivityRepository extends PageableRepository<DailyActivity, Long> {

    List<DailyActivity> findByActivityName(String activityName);

    Optional<DailyActivity> findByActivityId(Long activityId);

    List<DailyActivity> findByLocationName(String locationName);

}
