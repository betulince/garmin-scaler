FROM gradle:8.2-jdk17 AS build
COPY . /app
WORKDIR /app
RUN gradle build

FROM eclipse-temurin:17
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]