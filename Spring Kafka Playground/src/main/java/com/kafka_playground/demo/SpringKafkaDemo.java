package com.kafka_playground.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class SpringKafkaDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaDemo.class, args);
	}

	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("kafka-playground")
				.build();
	}

}
