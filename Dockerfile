# Use a stable, maintained base image for Java 21
FROM eclipse-temurin:21-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Copy the built JAR into the container
COPY target/vidhan-portfolio-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
