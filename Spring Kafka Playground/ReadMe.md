## Spring Kafka Playground

Here I will be learning and experimenting with using the Spring Kafka libraries and testing new stuff out!

Spring Kafka is actually really helpful to use Kafka easily within a Spring app. I have found that it is great for simple
stuff, but when we get complex you can dive really deep into the Spring world that I don't think was intended.
For example, consuming from multiple topics where each topic needs to connect to different brokers - Spring-boot wasn't built for
super complex implementations, but the docs are somewhat manageable and you can usually figure it out after some digging.

Check out the docs [here](https://docs.spring.io/spring-kafka/docs/current/reference/html/)! 

### Running the app
- Use Java 11
- run `docker compose up --detach` to get an instance of Kafka and Zookeeper going  
- Post messages to the microservices in order to publish to the kafka topic. Or use 
  ```kafka-console-producer --bootstrap-server localhost:9092 --topic kafka-playground```
  to setup a producer on the command line. 
  
