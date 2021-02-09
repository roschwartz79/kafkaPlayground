import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ContainerProperties
import org.springframework.kafka.listener.KafkaMessageListenerContainer
import org.springframework.kafka.listener.MessageListener
import java.util.*

/**
 * This is an example of how to use Spring Kafka without "Spring" or Spring Boot in order to consume messages! Soon I will
 * do producers this way without Spring Boot. The Spring libraries actually do a nice job of abstracting us from the
 * java kafka client libraries, as shown in a different project in the playground.
 */

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val container = kafkaPlaygroundMessageListenerContainer()
        container.start()
    }

    private fun kafkaPlaygroundMessageListenerContainer(): KafkaMessageListenerContainer<Void, String> {
        val containerProperties = ContainerProperties("kafka-playground")
        containerProperties.messageListener = listener()
        return KafkaMessageListenerContainer(consumerFactory(), containerProperties)
    }

    private fun consumerFactory(): ConsumerFactory<Void, String> {
        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "kafka:9092"
        props[ConsumerConfig.GROUP_ID_CONFIG] = "rob-test-barebones"
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        return DefaultKafkaConsumerFactory(props)
    }


    private fun listener(): Listener {
        return Listener()
    }

    class Listener : MessageListener<Void?, String?> {
        override fun onMessage(record: ConsumerRecord<Void?, String?>) {
            println("Consumed: ${record.value()}")
        }

        companion object {
            private val log = LoggerFactory.getLogger(Listener::class.java)
        }
    }
}