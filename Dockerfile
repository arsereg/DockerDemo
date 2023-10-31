#Stage 1
FROM maven:3.9.5-eclipse-temurin-17-focal as stage1
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /cenfo/demo
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean install
#Stage 2
FROM eclipse-temurin:17.0.9_9-jre-focal
WORKDIR /cenfo/demo
COPY --from=stage1 /cenfo/demo/target/DockerDemo-0.0.1-SNAPSHOT.jar /cenfo/demo
ENTRYPOINT ["java", "-jar", "./DockerDemo-0.0.1-SNAPSHOT.jar"]