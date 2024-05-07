# Build stage
FROM maven:3.9.6-eclipse-temurin-22
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src

# Runtime stage
FROM amazoncorretto:22
ARG PROFILE=dev
ARG APP_VERSION=0.0.1-SNAPSHOT

WORKDIR /app
COPY --from=build /build/target/dota-api-*.jar /app/

# Extract JAR version
