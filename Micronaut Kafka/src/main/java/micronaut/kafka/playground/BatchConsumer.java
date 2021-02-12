package micronaut.kafka.playground;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;

import java.util.List;

/**
 * An example of a batch consumer with Micronaut
 *
 * Next Steps:
 * - How to deserialize into a message object?
 * I tried to use the argument List<Message> messages but Micronaut couldn't serialize the JSON string into a Message object.
 * To be continued....
 */

@KafkaListener(offsetReset = OffsetReset.EARLIEST, batch = true)
public class BatchConsumer {

    @Topic("kafka-playground-micronaut-batch")
    public void receiveBatch(List<String> messages) {
        System.out.println("Got batch with size " + messages.size());
        for (String message: messages) {
            System.out.println("Consumed " + message);
        }
    }

}
