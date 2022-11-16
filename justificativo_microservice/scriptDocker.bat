call mvnw clean install -DskipTests
call docker build -t danaxar/justificativo-microservice .
call docker push danaxar/justificativo-microservice