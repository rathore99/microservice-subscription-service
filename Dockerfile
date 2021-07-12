FROM java:8
EXPOSE 9090
ADD /target/subscription-service-0.0.1-SNAPSHOT.jar subscription-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","subscription-service-0.0.1-SNAPSHOT.jar"]