package com.example.stackroute.gamemanager.kafka;

import com.example.stackroute.gamemanager.domain.Game;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    private Game recievedPayload;

    public Game getRecievedPayload()
    {
        return this.recievedPayload;
    }

    @KafkaListener(topics = "games", groupId = "games-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload Game payload) {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Recieved : ");
//        System.out.println(payload);

        this.recievedPayload = payload;
    }

}
