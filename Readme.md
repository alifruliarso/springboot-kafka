<!--
  Title: Kafka Consumer and Producer using Spring Boot
  Description: Spring Boot Kafka, Scaling consumer
  -->

# Kafka Consumer and Producer using Spring Boot

This project built to demonstrate Kafka Consumer and Producer using Spring Boot.
Also experiment with scaling consumer to handle slower consumer problem.

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

Create topic **random-number** with 3 partitions.
[Open kafka-ui](http://localhost:8080/)

Start Producer and consumer

```bash
  #Windows Powershell
  docker-compose-v1.exe -f .\producer-consumer.yml up
```
Use buildkit to build docker images.
```bash
  # Windows Powershell for docker-compose build ... (additional!)
  $env:COMPOSE_DOCKER_CLI_BUILD = 1;$env:DOCKER_BUILDKIT = 1;docker-compose-v1.exe -f .\producer-consumer.yml build
  
  #Linux
  COMPOSE_DOCKER_CLI_BUILD=1 DOCKER_BUILDKIT=1 docker-compose -f producer-consumer.yml build
```

Experiment with scaling consumer in consumer-group
```bash
  #Making consumer slower than producer. Edit producer-consumer.yml:
  MESSAGE_PROCESSING_TIME=2000
  #Try to scale up consumer. Number of consumer == number of partition
  docker-compose-v1.exe -f .\producer-consumer.yml up --scale sbconsumer=3
```

## Related

Here are some related resources used  in this  project.

- [Spring Boot Docker - Multi build stage](https://spring.io/guides/topicals/spring-boot-docker)
- [Use Buildkit to cache dependencies between multiple builds](https://www.baeldung.com/ops/docker-cache-maven-dependencies)
- [UI for Apache Kafka](https://github.com/provectus/kafka-ui)
- [Kafka – Scaling Consumers Out In A Consumer Group](http://www.vinsguru.com/kafka-scaling-consumers-out-for-a-consumer-group/)
- [Scale Kafka Consumers](https://catherine-shen.medium.com/scale-kafka-consumers-481be563bf3c)
- [Multi-Threaded Message Consumption with the Apache Kafka Consumer](https://www.confluent.io/blog/kafka-consumer-multi-threaded-messaging/)