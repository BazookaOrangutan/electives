FROM openjdk:23-jdk-slim
VOLUME /tmp
COPY target/electives-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]