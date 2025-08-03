package com.garmin.scaler.metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.inject.Singleton;

import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class ActivityMetrics {

    private final AtomicInteger uploadedActivitiesGauge = new AtomicInteger(0);

    public ActivityMetrics(MeterRegistry meterRegistry) {
        Gauge.builder("activities.uploaded.gauge", uploadedActivitiesGauge, AtomicInteger::get)
                .description("Current count of uploaded activities")
                .register(meterRegistry);
    }

    public void incrementGauge() {
        uploadedActivitiesGauge.incrementAndGet();
    }

}
