FROM gradle:7.6.0-jdk11-alpine AS gradle

COPY ./src src/
COPY ./settings.gradle settings.gradle
COPY ./build.gradle build.gradle

RUN gradle clean build

FROM amazoncorretto:11-alpine-jdk

RUN mkdir /opt/app
WORKDIR /opt/app

# Copy built spring application
COPY --from=gradle /home/gradle/build/libs/summator-0.0.1-SNAPSHOT.jar ./summator.jar

# Copy run script
COPY --chmod=777 scripts/run_app.sh run_app.sh

EXPOSE 8080

WORKDIR /opt/app
CMD ["/opt/app/run_app.sh", "summator.jar"]