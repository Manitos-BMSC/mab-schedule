FROM --platform=linux/x86_64 eclipse-temurin:17-jdk AS build


EXPOSE 8013

VOLUME /tmp

# Server
ENV PORT="PORT"
# Database
ENV POSTGRES_USERNAME="POSTGRES_USERNAME"
ENV POSTGRES_PASSWORD="POSTGRES_PASSWORD"
ENV POSTGRES_URL="POSTGRES_URL"

# Config server
ENV CONFIG_SERVER_URI="CONFIG_SERVER_URI"
ENV CONFIG_SERVER_PROFILE="CONFIG_SERVER_PROFILE"

# Eureka
ENV EUREKA_SERVER_URI="EUREKA_SERVER_URI"

# Keycloak
ENV KEYCLOAK_REALM="KEYCLOAK_REALM"
ENV KEYCLOAK_OPEN_ID="KEYCLOAK_OPEN_ID"


ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","bo.edu.ucb.mabschedule.mabschedule.MabScheduleApplication"]