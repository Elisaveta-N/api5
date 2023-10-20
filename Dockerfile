FROM openjdk:17-jdk-alpine
WORKDIR "/app"
COPY "/build/libs/api5.jar" "/app"
CMD java -Dserver.port=$PORT $JAVA_OPTS -jar api5.jar