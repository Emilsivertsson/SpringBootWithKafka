package com.CodeForPizza.SpringBootWithKafka.controller;

import com.CodeForPizza.SpringBootWithKafka.Kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController annotation is used to mark the class as a RestController.
@RestController
@RequestMapping("api/v1/kafka") // @RequestMapping annotation is used to map the web request.
public class MessageController {

    // KafkaProducer is used to send the messages to the topic.
    private KafkaProducer kafkaProducer;

    // Constructor based Dependency injection to inject the KafkaProducer into the class.
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    // http://localhost:8080/api/v1/kafka/publish?message=HelloWorld
    // publish() method is used to send the messages to the topic.
    @RequestMapping("/publish") // @RequestMapping annotation is used to map the web request.
    public ResponseEntity<String> publish(@RequestParam("message") String message) { // @RequestParam marks the parameter as a request parameter.
        kafkaProducer.sendMessage(message); // sendMessage() method is used to send the messages to the topic.
        return ResponseEntity.ok("Message sent to Topic"); // ResponseEntity is used to set the response status code and body.
    }

}
