import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class Main {
    public static void main (String args[]){

        // Here we configure our properties, and we use the built in String serializer to serialize our key and value
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // create our new Kafka producer object
        KafkaProducer producer = new KafkaProducer<String, String>(kafkaProps);

        // Setup a producerRecord (There are many constructors we can use, this is the most basic)
        ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Precision Products", "France");

        // simplest way to send a message. We won't know if it succeeds or not
        try {
            producer.send(record);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        // Sending a message synchronously, we will wait until kafka tells us it sent correctly
        try {
            producer.send(record).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sending a message asynchronously so we can send messages, and not worry if they succeeded right away
        producer.send(record, new DemoProducerCallback());
    }

    private static class DemoProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e){
            if (e!= null){
                e.printStackTrace();
            }
        }
    }
}
