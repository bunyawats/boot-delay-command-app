package com.ssc.rabbitmq.DelayCommandApp.controller;


import com.ssc.rabbitmq.DelayCommandApp.service.mq.sender.MessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SendMessageController {

    @Autowired
    MessageSender messageSender;

    @GetMapping( value = "sendMessage2Rabbit")
    public String sendMessage(@RequestParam  String message) {
        log.info ( "param message: {}", message );
        messageSender.send(message);

        return message;
    }
}
