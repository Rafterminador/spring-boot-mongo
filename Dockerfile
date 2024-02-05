FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/springboot-mongo-app-0.0.1-SNAPSHOT.jar mi-aplicacion.jar
ENTRYPOINT ["java","-jar","/app/mi-aplicacion.jar"]
