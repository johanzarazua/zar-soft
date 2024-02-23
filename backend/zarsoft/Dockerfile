# FROM maven:3.6.0-jdk-11-slim
FROM amazoncorretto:17

# Install maven
RUN yum install -y tar which gzip # TODO remove

# common for all images
ENV MAVEN_HOME /usr/share/maven

COPY --from=maven:3.9.6-eclipse-temurin-11 ${MAVEN_HOME} ${MAVEN_HOME}
COPY --from=maven:3.9.6-eclipse-temurin-11 /usr/local/bin/mvn-entrypoint.sh /usr/local/bin/mvn-entrypoint.sh
COPY --from=maven:3.9.6-eclipse-temurin-11 /usr/share/maven/ref/settings-docker.xml /usr/share/maven/ref/settings-docker.xml

RUN ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

ARG MAVEN_VERSION=3.9.6
ARG USER_HOME_DIR="/root"
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

COPY src /home/app/src
COPY pom.xml /home/app
COPY wallet /home/app/wallet
RUN mvn -f /home/app/pom.xml clean install -DskipTests=true test

ARG spring_profile

ENV SPRING_PROFILE ${spring_profile}
ENV ZARSOFT_HOME=/usr/local/lib
COPY wallet /usr/local/lib/wallet
# COPY src/main/resources/config/certs/Zarsoft.crt /usr/local/lib/config/Zarsoft.crt
# COPY src/main/resources/config/certs/keystore.p12 /usr/local/lib/config/keystore.p12
COPY src/main/resources/config/certs/*.pem  /usr/local/lib/config/certs/
COPY src/main/resources/application.properties /usr/local/lib/config/application.properties
COPY src/main/resources/config/application-${SPRING_PROFILE}.properties /usr/local/lib/config/application-${SPRING_PROFILE}.properties
# COPY target/zarsoft-0.0.1-SNAPSHOT.jar /usr/local/lib/deployments/zarsoft.jar
# RUN cd $JAVA_HOME/lib/security && \
#     keytool -import -alias zarsoft -keystore zarsoft.jks -storepass zarsoft -file  /usr/local/lib/config/Zarsoft.crt && \
#     keytool -importkeystore -noprompt -destkeystore zarsoft.jks -srckeystore /usr/local/lib/config/keystore.p12 \
#     -srcstoretype pkcs12 -alias zarsoft -storepass zarsoft -srcstorepass zarsoft
# RUN ls -alrth /home/app/target; \
#   mkdir -p -v /usr/local/lib/deployments; \
#   cp /home/app/target/zarsoft-0.0.1-SNAPSHOT.jar /usr/local/lib/deployments/zarsoft.jar; \
#   ls -alrth /usr/local/lib/;
RUN  mkdir -p -v /usr/local/lib/deployments && cp /home/app/target/zarsoft-0.0.1-SNAPSHOT.jar /usr/local/lib/deployments/zarsoft.jar

ENTRYPOINT [ "java", "-jar", "-Dspring.config.additional-location=file:/usr/local/lib/config/application-${SPRING_PROFILE}.properties", "/usr/local/lib/deployments/zarsoft.jar", "--spring.profiles.active=${SPRING_PROFILE}"]
