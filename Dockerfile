# Use Java 17 runtime image
FROM eclipse-temurin:17-jre

# Copy your JAR into the container
COPY api-service-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8090
EXPOSE 8090

# Command to run your Spring Boot app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]