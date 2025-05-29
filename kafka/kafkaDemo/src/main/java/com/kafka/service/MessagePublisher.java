package com.kafka.service;

import com.kafka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


import java.util.concurrent.CompletableFuture;

@Service
public class MessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;

  public void sendMessage(String msg){
      CompletableFuture<SendResult<String, Object>>  future = template.send("topic-1", msg);


      future.whenComplete( (result,ex)->{
        if(ex ==null){
            System.out.println("Message Send "+msg +" offset : "+result.getRecordMetadata().offset()+" producer record"+result.getProducerRecord());

        }
        else
            System.out.println("exception Occured : "+ ex.getMessage());
     });
  }

    public void sendUserData(User user) {
        CompletableFuture<SendResult<String, Object>> send = template.send("user-data", user);
        send.whenComplete((result,ex)->{
            if(ex==null){
                System.out.println(result.getRecordMetadata().offset()+" user data"+user);
            }
            else{
                ex.getMessage();
            }
        });

    }
}
