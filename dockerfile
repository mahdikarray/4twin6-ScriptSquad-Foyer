# Use a base image with JDK 11 installed
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Install curl (if not already installed) to download artifacts
RUN apk --no-cache add curl

# Download the Spring Boot application JAR file from Nexus
RUN curl -u admin:nexus "http://192.168.1.21:8081/repository/twin6-scriptSquad-foyer/com/example/twin6scriptsquadfoyer/0.0.1-SNAPSHOT/twin6scriptsquadfoyer-0.0.1-20240409.025632-63.jar"  --output /app/twin6scriptsquadfoyer-0.0.1-20240409.025632-63.jar
	
# Expose the port that the Spring Boot application will run on
EXPOSE 8083

# Specify the command to run the Spring Boot application when the container starts
ENTRYPOINT ["java", "-jar", "twin6scriptsquadfoyer-0.0.1-20240409.025632-63.jar"]





