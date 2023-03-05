FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests=true

FROM mcr.microsoft.com/java/jre:17-zulu-alpine
EXPOSE 8080
ARG JAR_FILE=target/Dilim-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "/application.jar"]
