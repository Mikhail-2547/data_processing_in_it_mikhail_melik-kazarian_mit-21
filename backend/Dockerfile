FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/music_album_db.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]