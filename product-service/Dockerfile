FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy JAR built by CI
COPY target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]