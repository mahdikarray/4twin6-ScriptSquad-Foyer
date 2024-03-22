# Start with a new base image
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file generated by Maven build
COPY target/twin6scriptsquadfoyer-0.0.1-SNAPSHOT.jar twin6scriptsquadfoyer.jar

# Expose the port the app runs on
EXPOSE 8087

# Define the command to run your application
ENTRYPOINT ["java", "-jar", "twin6scriptsquadfoyer.jar"]
