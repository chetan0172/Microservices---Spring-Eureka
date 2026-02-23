FROM eclipse-temurin:17-jre-alpine


WORKDIR /app

COPY target/*.jar app.jar

RUN adduser -D appuser

USER appuser

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]