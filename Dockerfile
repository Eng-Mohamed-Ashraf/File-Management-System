# Use a base image with Java and Maven installed
FROM maven:3.8.4-openjdk-11-slim AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests

# Create a lightweight image with only the JAR file
FROM openjdk:11-jre-slim

# Set environment variables
ENV PORT=8080

# Copy the JAR file built in the previous stage
COPY --from=builder /app/target/your-application.jar /app/your-application.jar

# Expose the port
EXPOSE $PORT

# Command to run the application
CMD ["java", "-jar", "/app/your-application.jar"]
