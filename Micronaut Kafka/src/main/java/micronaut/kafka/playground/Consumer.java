package micronaut.kafka.playground;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import micronaut.kafka.playground.model.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.List;

/**
 * This is an example of a kafka consumer with Micronaut!
 *
 * Wish list:
 * - Concurrent Consumers
 * - Implement listening from 2 topics on different brokers (A config change)
 * - batch listening
 */


@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class Consumer {

    @Topic("kafka-playground-micronaut")
    public void receive(String message) {
        System.out.println("Consumed " + message + " from topic kafka-playground-micronaut");
    }

    @Topic("kafka-playground-micronaut-2")
    public void receive2(String message) {
        System.out.println("Consumed " + message + " from topic kafka-playground-micronaut-2");
    }

    @Topic("kafka-playground-micronaut-batch")
    public void receiveBatch(List<String> messages) {
        System.out.println("Got batch with size " + messages.size());
        for (String message: messages) {
            System.out.println("Consumed " + message);
        }
    }
}