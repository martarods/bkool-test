FROM openjdk:17
MAINTAINER martars

COPY ./bikeproject-boot/target/bikeproject-boot-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
