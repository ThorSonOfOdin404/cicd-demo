# Stage 1: Build the application
FROM amazoncorretto:21-alpine3.21 AS builder

WORKDIR /app

# Copy Maven wrapper and project configuration files first for better caching
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies (this layer will be cached unless dependencies change)
RUN ./mvnw dependency:go-offline -B

# Copy the actual source code and package the application
COPY src ./src
RUN ./mvnw package -DskipTests

# Stage 2: Run the application
FROM amazoncorretto:21-alpine3.21 AS alpine

WORKDIR /app

# Copy the built jar artifact from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port (adjust if your app uses a different port)
EXPOSE 8090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]