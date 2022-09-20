package com.galapea.belajar.sbkafkaproducer;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.scheduling.annotation.*;

@EnableScheduling
@SpringBootApplication
public class SbKafkaProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SbKafkaProducerApplication.class, args);
  }
}
