FROM openjdk:8
ADD target/dockerized-spring-boot.jar  dockerized-spring-boot.jar
RUN ls -la
EXPOSE 8081
ENTRYPOINT ["java","-jar","dockerized-spring-boot.jar"]