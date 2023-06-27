FROM eclipse-temurin:17-jdk-alpine
MAINTAINER 'Ganesh Job Applicant for eSource'
COPY build/libs/E-Source-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "E-Source-1.0-SNAPSHOT.jar"]