package com.ssc.rabbitmq.DelayCommandApp.service.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

import static com.ssc.rabbitmq.DelayCommandApp.config.Constant.queueName;

@Slf4j
@Component
public class MessageReceiver {

    private CountDownLatch latch = new CountDownLatch(1);

    @RabbitListener(queues = queueName)
    public void receiveMessage(String message) {
        log.info ( "\n\n Received : {} \n at {} \n\n", message, new Date ( ) );
        latch.countDown ( );
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
