package com.garmin.scaler;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.runtime.Micronaut;

@Introspected(
        packages = "com.garmin.scaler.model",
        includedAnnotations = io.micronaut.data.annotation.MappedEntity.class
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}