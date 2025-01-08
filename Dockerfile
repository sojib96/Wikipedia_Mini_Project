FROM openjdk:21-jdk-slim AS build

WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

COPY . .

RUN mvn dependency:resolve
RUN mvn clean
