package com.kafka_playground.demo;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.utils.KafkaTestUtils;

@SpringBootTest
class SpringKafkaDemoTests {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private Consumer consumer;


	@BeforeEach
	void before() {
		kafkaTemplate.flush();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testKafka() {
		kafkaTemplate.send("test", "Hi");
		ConsumerRecord received = KafkaTestUtils.getSingleRecord(consumer, "topic");
		assert(received.toString()).equals("Hi");
	}


}
