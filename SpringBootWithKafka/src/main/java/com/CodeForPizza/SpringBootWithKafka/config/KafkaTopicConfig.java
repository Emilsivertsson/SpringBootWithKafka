package com.CodeForPizza.SpringBootWithKafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

// @Configuration annotation is used to mark the class as a configuration class.
@Configuration
public class KafkaTopicConfig {


    // javaguidesTopic() method is used to create a topic with the name javaguides.
    @Bean // @Bean annotation is used to indicate that a method produces a bean to be managed by the Spring container.
    public NewTopic javaguidesTopic(){ // NewTopic is used to create a new topic.
        return TopicBuilder.name("javaguides") // name() method is used to set the name of the topic.
                //.partitions(1) // partitions() method is used to set the number of partitions.
                //.replicas(1) // replicas() method is used to set the number of replicas.
                .build(); // build() method is used to create a new topic.

    }

    // javaguidesJsonTopic() method is used to create a topic with the name javaguides_json.
    @Bean
    public NewTopic javaguidesJsonTopic(){
        return TopicBuilder.name("javaguides_json")
                .build();

    }
}
