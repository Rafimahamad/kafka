package com.kafka.controller;


import com.kafka.entity.User;
import com.kafka.service.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaEventController {

    @Autowired
    private MessagePublisher messagePublisher;


    @GetMapping("/send/{msg}")
public ResponseEntity<?> publishMessage(@PathVariable String msg){
    try{
        messagePublisher.sendMessage(msg);
        return  ResponseEntity.ok("Message published Successfully !");
    }catch (Exception ex){
        ex.getMessage();
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}



    @PostMapping("/send/user")
    public ResponseEntity<?> publishUserDetails(@RequestBody User user){
        try{
            messagePublisher.sendUserData(user);
            return  ResponseEntity.ok("Message published Successfully !");
        }catch (Exception ex){
            ex.getMessage();
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
