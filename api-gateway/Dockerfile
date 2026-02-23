# ---------- Stage 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy entire multi-module project
COPY . .

# Build only api-gateway and required dependencies (parent)
RUN mvn -pl api-gateway -am clean package -DskipTests

# ---------- Stage 2: Runtime ----------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy generated JAR from builder stage
COPY --from=builder /app/api-gateway/target/api-gateway-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]