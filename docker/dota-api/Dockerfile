# Build stage
FROM maven:3.9.6-eclipse-temurin-22 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src

# Runtime stage
FROM amazoncorretto:latest
ARG PROFILE=dev
ARG APP_VERSION=0.0.1-SNAPSHOT
ARG DATABASE_URL=jdbc:postgresql://postgres-sql-gamingle:5432/gamingle

WORKDIR /app
COPY --from=build /build/target/dota-api-*.jar /app/

# Extract the JAR version
RUN APP_VERSION=$(ls /app | grep *.jar | awk 'NR==2{split($0,a,"-"); print a[3]}' | awk '{sub(/.jar$/,"")}1')\
    && echo "Building container with dota-api v-$version"
EXPOSE 8088

ENV ACTIVE_PROFILE=${PROFILE}
ENV DB_URL=${DATABASE_URL}
ENV JAR_VERSION=${APP_VERSION}

CMD java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} -Dspring.datasource.url=${DB_URL}  dota-api-${JAR_VERSION}.jar
