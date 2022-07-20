FROM openjdk:18
EXPOSE 8080:8080
COPY build/libs/  /tmp
WORKDIR /tmp
CMD chmod +rwx ktor-api-0.0.1-all.jar
CMD java -jar ktor-api-0.0.1-all.jar
