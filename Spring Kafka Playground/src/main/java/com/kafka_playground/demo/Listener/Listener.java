package com.kafka_playground.demo.Listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Listener {

    @KafkaListener(topics = "kafka-playground")
    public void listen(@Payload String message)  throws Exception {
        System.out.println("Consumed " + message);
    }

    @KafkaListener(topics = "kafka-playground-2")
    public void listenNewTopic(@Payload String message) throws Exception {
        System.out.println("Consumed " + message);
    }
}
