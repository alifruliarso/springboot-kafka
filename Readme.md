<!--
  Title: Kafka Consumer and Producer using Spring Boot
  Description: Spring Boot Kafka
  -->

# Kafka Consumer and Producer using Spring Boot

This project built to demonstrate Kafka Consumer and Producer using Spring Boot.

## Run Locally

Clone the project

```bash
  git clone git@github.com:ruliarso/springboot-kafka.git
```

Start Kafka Cluster

```bash
  #Windows Powershell
  docker-compose-v1.exe -f .\kafka-cluster.yaml up
```

Start Producer and consumer

```bash
  #Windows Powershell
  docker-compose-v1.exe -f .\producer-consumer.yml up
```
Use buildkit
```bash
  # Windows Powershell for docker-compose build ... (additional!)
  $env:COMPOSE_DOCKER_CLI_BUILD = 1;$env:DOCKER_BUILDKIT = 1;docker-compose-v1.exe -f .\producer-consumer.yml build
  
  #Linux
  COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose -f producer-consumer.yml build
```

## Related

Here are some related resources used  in this  project.

- [Spring Boot Docker - Multi build stage](https://spring.io/guides/topicals/spring-boot-docker)
- [Use Buildkit to cache dependencies between multiple builds](https://www.baeldung.com/ops/docker-cache-maven-dependencies)
- [UI for Apache Kafka](https://github.com/provectus/kafka-ui)