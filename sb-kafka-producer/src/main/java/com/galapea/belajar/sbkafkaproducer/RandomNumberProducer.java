package com.galapea.belajar.sbkafkaproducer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;

import java.net.*;
import java.util.concurrent.*;

@Component
public class RandomNumberProducer {

  private static final int MIN = 10;
  private static final int MAX = 100_000;

  @Autowired private KafkaTemplate<String, String> kafkaTemplate;

  @Scheduled(fixedRate = 1000)
  public void produce() throws UnknownHostException {
    int random = ThreadLocalRandom.current().nextInt(MIN, MAX);
    this.kafkaTemplate.sendDefault(String.valueOf(random));
    // just for logging
    String hostName = InetAddress.getLocalHost().getHostName();
    System.out.println(String.format("%s produced %d", hostName, random));
  }
}
