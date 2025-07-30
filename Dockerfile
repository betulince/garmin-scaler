FROM amazoncorretto:17
WORKDIR /app
COPY build/libs/garmin-scaler-0.1-all.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]