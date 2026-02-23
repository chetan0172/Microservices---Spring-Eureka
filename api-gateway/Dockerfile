FROM eclipse-temurin:17-jre-alpine

RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

WORKDIR /app

COPY target/*.jar app.jar

RUN chown -R appuser:appgroup /app


USER appuser

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]