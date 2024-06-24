
FROM maven:3.3.1-openjdk-17 AS build
WORKDIR /home/dynamodblocal
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app-node
COPY --from=build /app/target/app-node.jar app-node.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app-node.jar"]
