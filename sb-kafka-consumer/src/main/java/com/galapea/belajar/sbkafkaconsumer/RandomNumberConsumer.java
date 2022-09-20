package com.galapea.belajar.sbkafkaconsumer;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

import java.net.*;

@Component
public class RandomNumberConsumer {

  @Value("${message.processing.time}")
  private long processingTime;

  @KafkaListener(topics = "random-number")
  public void consumer(String message) throws UnknownHostException, InterruptedException {
    String hostName = InetAddress.getLocalHost().getHostName();
    System.out.println(
        String.format(
            "%s consumed %s, sleep in %d milliseconds", hostName, message, processingTime));
    Thread.sleep(processingTime);
  }
}
