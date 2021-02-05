### Some helpful scripts to run in the repo and just with Kafka in general

To list all of the topics associated with your local zookeeper instance:
`kafka-topics --list --zookeeper localhost:2181`

- Produce from the command line!

``` 
kafka-console-producer --bootstrap-server localhost:9092 --topic kafka-playground
```

- Consume from the Kafka Playground topic!
```
kafka-console-consumer --bootstrap-server localhost:9092 --from-beginning --group rob_1 --topic kafka-playground
```

