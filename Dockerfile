
FROM openjdk:17-jdk-slim
COPY target/incident-0.0.1-SNAPSHOT.jar incident-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java" , "-jar" , "/incident-0.0.1-SNAPSHOT.jar"]
