FROM amazoncorretto:11-alpine-jdk
MAINTAINER WGTA //quien es el dueño 
COPY target/wgta-0.0.1-SNAPSHOT.jar wgta-app.jar  //Va a copiar el empaquetado a github
ENTRYPOINT ["java", "-jar", "/wgta-app.jar"]   //Es la instruccion que se va a ejecutar primero
