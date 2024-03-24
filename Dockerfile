# Start with a new base image to create a minimal container
#FROM openjdk:17

#WORKDIR /app

# Copy the jar file from the previous stage
#COPY target/*.jar devops-integration.jar

# Expose the port the app runs on
#EXPOSE 8087

#ADD target/MOUNIR-BEN-ROMDHANE-UNIVERSITY.jar devops-integration.jar
#ENTRYPOINT ["java","-jar","devops-integration.jar"]

FROM openjdk:17-alpine

WORKDIR /app
RUN apk --no-cache add curl


RUN curl -u admin:201JMt4720 "http://192.168.33.10:8081/repository/twin6-scriptSquad-foyer/com/example/twin6scriptsquadfoyer/0.0.1-SNAPSHOT/twin6scriptsquadfoyer-0.0.1-20240322.011257-3.jar"  --output /app/twin6scriptsquadfoyer.jar

EXPOSE 8087
ENTRYPOINT ["java", "-jar", "twin6scriptsquadfoyer.jar"]
