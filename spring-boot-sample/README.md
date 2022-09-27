# Overview

The purpose is to illustrate on how a `docker image` can be built and run, of a basic `Spring Boot application` with simple rest-endpoints and <u>no external dependencies</u> (e.g., app / db / message broker etc.)

## Requirements

1. Docker
1. Java 17
1. maven (tested with: `Apache Maven 3.8.6`)

## Build & Run

- open a `bash` terminal

- build the java project
```sh
mvn clean install
```
> This will create `spring-boot-sample-0.0.1-SNAPSHOT.jar` inside `target` folder

- build docker image
```sh
docker build -t <image-name>:<tag_name> <directory-of-Dockerfile>

e.g, docker build -t spring-boot-sample:latest .
```
> This will refer to the `Dockerfile` and create a new image. Run `docker images` to see all images.

- run the application
```sh
docker run -p 5151:5151 <image-name>:<tag_name>

e.g., docker run -p 5151:5151 spring-boot-sample:latest
```

This will start the application at port `5151` and it will assign a random container-name. To give a custom container-name, run the following command:

```sh
docker container run --rm -d --name <container-name> -p 5151:5151 <image-name>:<tag_name>

e.g., docker container run --rm -d --name spring-boot-sample-container -p 5151:5151 spring-boot-sample:latest
```
> - **--rm** will ensure that the container gets deleted once you stop
> - **-d** will start the application in detached mode
> - run `docker ps` to see the running containers

- stop the application
```sh
docker stop <container-name>

e.g., docker stop spring-boot-sample-container
```

## Test

- create data
```sh
curl --location --request POST 'localhost:5151/sample-app/v1/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "test_data"
}'
```

- get data
```sh
curl --location --request GET 'localhost:5151/sample-app/v1/getAll'
```

If `curl` is not configured locally, you can run the above commands in the following two ways as well:

1. from inside the container
```sh
docker exec -it <container-name> bash
```
> From `git bash`, run `winpty docker exec -it <container-name> bash`

2. import the curl command in [Postman](https://www.postman.com/downloads/)

> **Note:** You can also run `./build` from a bash terminal to create image.