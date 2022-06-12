FROM ubuntu:18.04

COPY . .

RUN yes|apt-get update
RUN yes|apt install maven
RUN yes|apt-get install systemd
RUN yes|apt-get install mongodb
RUN mkdir -p /data/db
	
CMD mongod --fork --syslog && mvn spring-boot:run
