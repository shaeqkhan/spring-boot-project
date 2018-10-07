# spring-boot-project
Proof of concept collaboration with Hakim

## Build
mvn clean install

## Package
mvn install dockerfile:build
docker image list

## Deploy
docker run -p 8080:8080 -t shaeqkhan/app

## Teardown
docker kill <countainer-id>