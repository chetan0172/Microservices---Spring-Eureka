FROM eclipse-temurin:17-jre-alpine

RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser

WORKDIR /app

# Copy JAR built by CI
COPY target/*.jar app.jar

RUN chown -R appuser:appgroup /app
USER appuser

EXPOSE 8083

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]