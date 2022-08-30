FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

## docker build -t demo .
## docker run -it -p 8080:8080 demo .
