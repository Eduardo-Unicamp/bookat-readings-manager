FROM ubuntu:latest AS build
LABEL authors="Eduardo Saldanha"

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

# Faz o build do projeto PULANDO OS TESTES (-DskipTests)
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

EXPOSE 8080

COPY --from=build /target/readings-manager-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]