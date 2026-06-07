# Estágio 1: Build (Usa a imagem oficial que JÁ VEM com Maven e Java 17)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Faz o build pulando os testes
RUN mvn clean package -DskipTests

# Estágio 2: Execução (Usa uma imagem mais leve só com Java 17)
FROM eclipse-temurin:17-jdk
WORKDIR /app

EXPOSE 8080

# Copia o arquivo compilado do Estágio 1
COPY --from=build /app/target/readings-manager-0.0.1-SNAPSHOT.jar app.jar

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]