# -------- Stage 1: Build --------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom first (better layer caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests


# -------- Stage 2: Runtime --------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Create non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Set ownership
RUN chown appuser:appgroup app.jar

USER appuser

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]