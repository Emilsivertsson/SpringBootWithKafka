package com.CodeForPizza.SpringBootWithKafka.Kafka;

import com.CodeForPizza.SpringBootWithKafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger Logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    // @KafkaListener annotation is used to listen the messages from the topic.
    @KafkaListener(topics = "javaguides_json", groupId = "myGroup") //specify the topic name and group id
    public void consume(User user) {
        Logger.info(String.format("Json message received: %s", user.toString()));
    }
}
