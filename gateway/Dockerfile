FROM gradle:8.7.0-jdk17-alpine AS gradle
# FROM gradle:7.6.0-jdk11-alpine AS gradle

COPY ./src src/
COPY ./settings.gradle settings.gradle
COPY ./build.gradle build.gradle

# ENV GRADLE_OPTS=-Xmx1024m

RUN gradle clean build

FROM amazoncorretto:17-alpine-jdk
# FROM amazoncorretto:11-alpine-jdk

RUN mkdir /opt/app
WORKDIR /opt/app

# Copy built spring application
COPY --from=gradle /home/gradle/build/libs/gateway-0.0.1-SNAPSHOT.jar ./gateway.jar

# Copy run script
COPY --chmod=777 scripts/run_app.sh run_app.sh
#COPY --chmod=777 scripts/execution-start.sh execution-start.sh
#COPY --chmod=777 scripts/execution-end.sh execution-end.sh

EXPOSE 8080

WORKDIR /opt/app
CMD ["/opt/app/run_app.sh", "gateway.jar"]