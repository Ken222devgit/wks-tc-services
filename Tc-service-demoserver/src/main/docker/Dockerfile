FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD tc-soademo-server-1.0-SNAPSHOT.jar app-tc-demo-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app-tc-demo-server.jar"]