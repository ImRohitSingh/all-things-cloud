FROM eclipse-temurin:17-jdk
LABEL maintainer="rohit"
RUN apt-get clean all \
	&& rm -rf /var/lib/apt/lists/* \
	&& apt-get -y update \
	&& apt-get -y upgrade \
	&& apt-get install --fix-missing --upgrade -y bash curl
RUN mkdir -p /usr/app/
ENV PROJECT_HOME /usr/app/
COPY target/spring-boot-sample-0.0.1-SNAPSHOT.jar $PROJECT_HOME/spring-boot-sample-0.0.1-SNAPSHOT.jar
WORKDIR $PROJECT_HOME
CMD ["java", "-jar", "./spring-boot-sample-0.0.1-SNAPSHOT.jar"]