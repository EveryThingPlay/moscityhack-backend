FROM ubuntu:18.04

COPY . .

RUN yes|apt-get update
RUN yes|apt install maven
RUN yes|apt-get install systemd
RUN yes|apt-get install mongodb
RUN mkdir -p /data/db
RUN mongod --fork -syslog

EXPOSE 8080
CMD mvn spring-boot:run
