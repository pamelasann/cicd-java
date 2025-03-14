FROM openjdk:17-jdk-slim
WORKDIR /app
COPY pom.xml /app/
COPY src /app/src/
RUN apt-get update && apt-get install -y maven
RUN mvn clean install -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/cicd_demo-0.0.1-SNAPSHOT.jar"]
