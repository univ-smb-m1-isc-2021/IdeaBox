FROM openjdk:17-oracle

COPY ./target/idea-box.jar .

EXPOSE 8080

CMD ["sh","-c","java -XX:InitialRAMPercentage=50 -XX:MaxRAMPercentage=70  -XshowSettings $JAVA_OPTS -jar idea-box.jar"]