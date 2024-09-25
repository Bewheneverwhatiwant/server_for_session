FROM openjdk:17-alpine

WORKDIR /app

ARG JAR_FILE=build/libs/front-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]