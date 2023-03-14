FROM maven:3.8.3-openjdk-17 as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn clean package

FROM maven:3.8.3-openjdk-17
COPY --from=build /usr/app/target/mouse-maps-app.jar mouse-maps-app.jar

COPY nginx/nginx.conf /etc/nginx/nginx.conf

ENTRYPOINT java -jar mouse-maps-app.jar