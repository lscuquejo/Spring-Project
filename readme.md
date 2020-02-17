# How to start this java "stack"
```
docker-compose up -d
```

## Database access
The mariadb password and port are defined in the docker-compose.yml.
This mariadb is accessible from inside the docker stack using the following configurations:
Host: mysql
Port: 3306
Username: root
Password: mysafepass

If you want to access it from outside of the docker stack.
Host: 127.0.0.1
Port: 3306
Username: root
Password: mysafepass

## Deploy new jar
To deploy a new jar you just need to copy your jar file to the path ./target/myjava.jar