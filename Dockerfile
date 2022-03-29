FROM openjdk:11
ADD target/ms-clients-0.0.1-SNAPSHOT.jar ms-client.jar
ENTRYPOINT ["java","-jar","ms-client.jar"]