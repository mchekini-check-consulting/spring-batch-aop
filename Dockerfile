FROM ubuntu
RUN apt-get update && apt-get install openjdk-11-jdk vim curl -y
RUN curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-7.10.1-linux-x86_64.tar.gz
RUN tar xzvf filebeat-7.10.1-linux-x86_64.tar.gz
WORKDIR /opt
ADD target/api-testeur-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9080", "/opt/app.jar"]