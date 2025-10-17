# Multi-stage Dockerfile: build con Gradle, runtime con JRE

# Stage 1: build
FROM gradle:8.6-jdk17 AS builder
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . /home/gradle/project
RUN gradle bootJar --no-daemon

# Stage 2: runtime
FROM eclipse-temurin:17-jre
ARG JAR_FILE=build/libs/tienda-online-0.0.1-SNAPSHOT.jar
COPY --from=builder /home/gradle/project/${JAR_FILE} /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

