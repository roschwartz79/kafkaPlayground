package micronaut.kafka.playground;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import micronaut.kafka.playground.model.Message;

import java.util.List;

/**
 * An example of a kafka producer with Micronaut, using a handy interface as an abstraction over Kafka java Client libs!
 * Wish list:
 * - Batch Sending
 * - What else can be dynamic with producing messages, other than the topic name and message?
 * - Add headers for partition info
 * - Explore the KafkaClient more and go deeper into how this interface is used
 */

@KafkaClient(id = "rob-test",
acks = KafkaClient.Acknowledge.ALL,
batch = true)
public interface Producer {

    @Topic("kafka-playground-micronaut")
    void sendMessage(String message);

    void sendMessage(@Topic String topic, String message);

    // We can have batch producers in the same interface as producers, just with one different param specified!
    @KafkaClient(batch=true)
    @Topic("kafka-playground-micronaut-batch")
    void send(List<Message> messages);
}