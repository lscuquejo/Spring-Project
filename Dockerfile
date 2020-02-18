FROM java:8-jdk-alpine
COPY ./app /usr/app/
COPY ./.mvn /usr/app/.mvn
WORKDIR /usr/app
RUN ./mvnw install
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/training-app-ws-0.0.1-SNAPSHOT.jar"]