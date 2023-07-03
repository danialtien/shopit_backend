FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar shopit.jar
ENTRYPOINT ["java","-jar","/shopit.jar"]
EXPOSE 8080