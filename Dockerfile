FROM openjdk:17-alpine

LABEL authors="MiguelCuadros"

WORKDIR /app

COPY target/vg-ms-teacher.jar vg-ms-teacher.jar

EXPOSE 8410

ENTRYPOINT ["java", "-jar", "vg-ms-teacher.jar"]