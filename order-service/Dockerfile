FROM eclipse-temurin:17-jre-alpine



WORKDIR /app

# Copy JAR built by CI
COPY target/*.jar app.jar

RUN adduser -D appuser

USER appuser

EXPOSE 8083

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]