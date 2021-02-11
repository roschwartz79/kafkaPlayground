package micronaut.kafka.playground.Controller;


import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import micronaut.kafka.playground.Producer;

import javax.inject.Inject;

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







}
