FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar

#docker build -t phamthi/restaurant-server:0.0.1 .
#docker login
#docker push phamthi/restaurant-server:0.0.1