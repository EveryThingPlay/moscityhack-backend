# Backend. SubSchool team. Moscow City Hackathon

## Зависимости
1) JDK 17
2) Spring Boot
3) Mupstruct
4) Lombok
5) MongoDB

## Запуск сервиса
#### Через плагин 'spring-boot'
Для Windows:
```text
mvnw.cmd spring-boot:run
```
Для Linux:
```text
./mvnw spring-boot:run
```
#### Через сборку JAR файла со всеми зависимостями через плагин 'maven-jar-plugin'
Для Windows:
```text
mvnw.cmd clean package
```
Для Linux:
```text
./mvnw clean package
```
В директории *target* исполняемый файл **backend-0.0.1-SNAPSHOT.jar**
```text
java -jar backend-0.0.1-SNAPSHOT.jar
```

## Недостатки
1) Реализация авторизации не обеспечивает открытие временной сессии (срок действия токена не ограничен)
2) Не обеспечена валидация данных при регистрации пользователя
3) Присутствует сильная связанность по модели Profile
