package com.kafka_playground.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/Produce")
    public String Produce(@RequestParam String message){
        kafkaTemplate.send("kafka-playground", message);
        return "Produced " + message;
    }

    @PostMapping("/ProduceToTopic")
    public String ProduceToTopic(@RequestParam String message, @RequestParam String topic){
        kafkaTemplate.send(topic, message);
        return "Produced " + message + " to topic " + topic;
    }

}
