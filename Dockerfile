FROM openjdk:11
EXPOSE 8080
ADD target/idea-box.jar
ENTRYPOINT ["java", "-jar", "/idea-box.jar"]
