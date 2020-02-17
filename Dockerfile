FROM java:8-jdk-alpine
COPY ./app/target/training-app-ws-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "training-app-ws-0.0.1-SNAPSHOT.jar"]