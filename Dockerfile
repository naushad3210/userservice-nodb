# Added slim adoptopenjdk
FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

ADD target/UserServiceWithoutDB.jar UserServiceWithoutDB.jar
EXPOSE 9093
ENTRYPOINT ["java", "-jar", "UserServiceWithoutDB.jar"]