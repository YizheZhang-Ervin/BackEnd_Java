FROM openjdk:11.0.2-jre-slim
COPY target/api-service-1.0.jar .
CMD /usr/bin/java -Xmx300m -Xms300m -XX:TieredStopAtLevel=1 -noverify -jar api-service-1.0.jar
EXPOSE 8000
