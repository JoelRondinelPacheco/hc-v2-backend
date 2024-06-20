FROM openjdk:17-jdk-alpine
COPY target/hackacode-1.0.0.jar app-1.0.0.jar

ENTRYPOINT ["java", "-jar", "app-1.0.0.jar"]