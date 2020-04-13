FROM openjdk:8u201-jdk-alpine3.9
MAINTAINER alewu wywujw@163.com

COPY target/wechat-0.0.1-SNAPSHOT.jar /wechat-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/wechat-0.0.1-SNAPSHOT.jar"]
