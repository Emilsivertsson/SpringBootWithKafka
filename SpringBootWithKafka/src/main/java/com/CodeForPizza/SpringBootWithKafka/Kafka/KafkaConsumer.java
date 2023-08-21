package com.CodeForPizza.SpringBootWithKafka.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger Logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consume(String message) {
        Logger.info(String.format("Consumed message:" + message));
    }
}
