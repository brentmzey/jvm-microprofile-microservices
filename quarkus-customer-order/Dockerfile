# --- Build Stage ---
# Use an official Gradle image with a JDK to build the app
FROM gradle:8.8-jdk21 AS build
WORKDIR /app

# Copy only the essential build files and source code
# This avoids copying the gradlew wrapper and uses the image's global gradle
COPY build.gradle settings.gradle gradle.properties /app/
COPY src /app/src

# Bust cache
ARG CACHE_BUSTER=2

# Build the executable uber-jar
RUN gradle quarkusBuild -Dquarkus.package.jar.type=uber-jar --no-daemon

# --- Run Stage ---
# Use a slim JRE for the final image
FROM openjdk:21-slim
WORKDIR /app

# Copy the built Quarkus uber-jar
COPY --from=build /app/build/quarkus-customer-order-*-runner.jar /app/application.jar

# Run the application
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
