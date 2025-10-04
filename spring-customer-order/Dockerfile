# --- Build Stage ---
# Use an official Gradle image with a JDK to build the app
FROM gradle:8.8-jdk21 AS build
WORKDIR /app

# Copy only the essential build files and source code
# This avoids copying the gradlew wrapper and uses the image's global gradle
COPY build.gradle settings.gradle /app/
COPY src /app/src

# Build the executable jar
RUN gradle build -x test --no-daemon

# --- Run Stage ---
# Use a slim JRE for the final image
FROM openjdk:21-slim
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/spring-customer-order-*.jar /app/app.jar

EXPOSE 8081
CMD ["java", "-jar", "/app/app.jar"]
