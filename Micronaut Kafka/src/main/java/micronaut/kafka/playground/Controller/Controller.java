package micronaut.kafka.playground.Controller;


import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import micronaut.kafka.playground.Producer;
import micronaut.kafka.playground.model.Message;

import javax.inject.Inject;
import java.util.List;

@io.micronaut.http.annotation.Controller
public class Controller {

    @Inject
    private Producer producer;


    @Get("/health")
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Up!";
    }


    @Post("/Produce")
    @Produces(MediaType.TEXT_PLAIN)
    public String publish(@QueryValue String message){
        producer.sendMessage(message);
        return "Produced " + message;
    }

    @Post("/ProduceToTopic")
    @Produces(MediaType.TEXT_PLAIN)
    public String publish(@QueryValue String message, @QueryValue String topic){
        producer.sendMessage(topic, message);
        return "Produced " + message + " to topic " + topic;
    }

    @Post("/ProduceBatch")
    @Produces(MediaType.TEXT_PLAIN)
    public String publishBatchMessage(@QueryValue String message1, @QueryValue String message2,
                                      @QueryValue String name1, @QueryValue String name2) {
        producer.send(List.of(new Message(message1, name1), new Message(message2, name2)));
        return "Success!";
    }







}
