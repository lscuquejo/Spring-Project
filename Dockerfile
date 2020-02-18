FROM java:8-jdk-alpine
COPY ./app /usr/app/
COPY ./.mvn /usr/app/.mvn
COPY ./docker/entrypoint.sh /usr/app/
RUN chmod +x /usr/app/entrypoint.sh
WORKDIR /usr/app

EXPOSE 8080
ENTRYPOINT ["/usr/app/entrypoint.sh"]
