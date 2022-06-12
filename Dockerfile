FROM maven

COPY . .

CMD mvn spring-boot:run
