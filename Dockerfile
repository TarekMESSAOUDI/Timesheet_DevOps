FROM openjdk:8-jre-alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \JAVA_OPTS=""
WORKDIR /app
ADD target/*.jar app.jar
EXPOSE 9090
CMD ["java", "-jar", "/app/app.jar"] 