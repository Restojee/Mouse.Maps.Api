FROM openjdk:19-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} mouse-maps-app.jar

COPY nginx/nginx.conf /etc/nginx/nginx.conf

EXPOSE 9000

ENTRYPOINT ["java","-jar","/app.jar"]