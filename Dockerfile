# Build Stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -X

# Package Stage
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/Calculator-0.0.1-SNAPSHOT.jar /app/Calculator-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "Calculator-0.0.1-SNAPSHOT.jar"]
