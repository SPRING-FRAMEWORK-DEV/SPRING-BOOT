Go to spring-boot-hello-world-master/
open cmd
mvn clean verify
java -jar -Dspring.config.location=../config/my-config.properties target/app.jar
http://localhost:8080/api
