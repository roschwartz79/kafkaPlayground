package micronaut.kafka.playground.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty("message")
    private String message;
    @JsonProperty("name")
    private String name;

    public Message(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
