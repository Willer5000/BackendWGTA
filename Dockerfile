FROM amazoncorretto:11-alpine-jdk
MAINTAINER WGTA
COPY target/wgta-0.0.1-SNAPSHOT.jar wgta-app.jar
ENTRYPOINT ["java", "-jar", "/wgta-app.jar"]   
