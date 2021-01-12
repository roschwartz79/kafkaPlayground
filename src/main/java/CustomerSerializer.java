import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.util.Map;

// An example of how to serialize a class!
// We would be able to define ProducerRecord<String, Customer> and send Customer data and pass Customer
// Objects directly to the producer.
public class CustomerSerializer implements Serializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // We don't need to configure anything
    }

    /**
     We are serializing Customer as:
     4 byte int representing customerId
     4 byte int representing length of customerName in UTF-8 bytes (0 if
     name is Null)
     N bytes representing customerName in UTF-8
     */
    @Override
    public byte[] serialize(String topic, Customer data) {
        try {
            byte[] serializedName;
            int stringSize;
            if (data == null)
                return null;
            else {
                if (data.getName() != null) {
                    serializedName = data.getName().getBytes("UTF-8");
                    stringSize = serializedName.length;
                } else {
                    serializedName = new byte[0];
                    stringSize = 0;
                }
            }

            ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + stringSize);
            buffer.putInt(data.getID());
            buffer.putInt(stringSize);
            buffer.put(serializedName);

            return buffer.array();
        } catch (Exception e) {
            throw new SerializationException(
                    "Error when serializing Customer to byte[] " + e);
        }
    }

    @Override
    public void close() {
        // Nothing to close
    }
}
