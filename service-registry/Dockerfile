# -------- Stage 1: Build --------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy entire project
COPY . .

# Build only service-registry
RUN mvn clean package -DskipTests -pl service-registry -am


# -------- Stage 2: Runtime --------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --from=build /app/service-registry/target/*.jar app.jar

RUN chown appuser:appgroup app.jar

USER appuser

EXPOSE 8761

ENTRYPOINT ["java","-jar","app.jar"]