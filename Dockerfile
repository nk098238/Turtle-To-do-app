FROM openjdk:17-jdk
ARG JAR_FILE=target/*.jar
COPY ./target/test-app-docker.jar test-app-docker.jar
ENTRYPOINT ["java","-jar","/test-app-docker.jar"]