FROM openjdk:17-jdk-alpine
MAINTAINER @nandini
COPY target/springmongo-0.0.1-SNAPSHOT.jar springmongo-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/springmongo-server-1.0.0.jar"]