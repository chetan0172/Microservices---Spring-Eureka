# ---------- Stage 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

COPY . .

RUN mvn -pl service-registry -am clean package -DskipTests

# ---------- Stage 2: Runtime ----------
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/service-registry/target/service-registry-1.0.0.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","app.jar"]