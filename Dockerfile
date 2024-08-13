FROM openjdk:19
COPY target/artist-platform-0.0.1-SNAPSHOT.jar hoxtify.jar
ENTRYPOINT ["java", "-jar", "hoxtify.jar"]