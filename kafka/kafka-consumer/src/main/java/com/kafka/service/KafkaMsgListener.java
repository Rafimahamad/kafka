package com.kafka.service;

import com.kafka.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMsgListener {


@KafkaListener(topics="topic-1",groupId = "receiver-group")
    public void consumer(String msg){
    System.out.println("------------------------------"+msg);
        log.info("Consumed msg{} ",msg);
    }

    @KafkaListener(topics="user-data",groupId = "user-group" ,containerFactory = "containerFactory")
    public void consumeObject(@Payload User user){
        System.out.println("-------------user Data -----------------"+user);
        log.info("Consumed user {} ",user);
    }

}
