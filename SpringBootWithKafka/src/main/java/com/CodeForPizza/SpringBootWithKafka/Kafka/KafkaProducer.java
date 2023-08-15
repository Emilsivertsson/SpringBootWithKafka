package com.CodeForPizza.SpringBootWithKafka.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

// @Service annotation is used to mark the class as a service provider.
@Service
public class KafkaProducer {

    // Logger is used to log the messages to the console.
    private static final Logger Logger = LoggerFactory.getLogger(KafkaProducer.class);

    // KafkaTemplate is used to send the messages to the topic.
    private KafkaTemplate<String, String> kafkaTemplate;

    // Constructor based Dependency injection to inject the KafkaTemplate into the class.
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // sendMessage() method is used to send the messages to the topic.
    public void sendMessage(String message) {
        Logger.info(String.format("Producing message: %s", message));
        kafkaTemplate.send("javaguides", message);
    }


}
