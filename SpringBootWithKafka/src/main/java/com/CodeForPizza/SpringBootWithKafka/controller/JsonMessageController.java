package com.CodeForPizza.SpringBootWithKafka.controller;

import com.CodeForPizza.SpringBootWithKafka.Kafka.JsonKafkaProducer;
import com.CodeForPizza.SpringBootWithKafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer KafkaProducer;

    public JsonMessageController(JsonKafkaProducer KafkaProducer) {
        this.KafkaProducer = KafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        KafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to Topic");
    }
}
