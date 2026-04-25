# ─── Etapa 1: Compilar con Maven ───────────────────────────
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia solo pom.xml primero para cachear dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Copia el código fuente y compila
COPY src ./src
RUN mvn package -DskipTests -q

# ─── Etapa 2: Imagen ligera para ejecutar ──────────────────
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
