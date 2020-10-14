package com.ssc.rabbitmq.DelayCommandApp.service.mq.sender;


import com.ssc.rabbitmq.DelayCommandApp.config.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        log.info ( "send message: {}", message );

        rabbitTemplate.convertAndSend (
                Constant.topicExchangeName,
                Constant.routingKey,
                message,
                new MessagePostProcessor ( ) {
                    @Override
                    public Message postProcessMessage(Message message) throws AmqpException {

                        message.getMessageProperties ( ).setDelay ( Constant.TWO_MINUTS );

                        return message;
                    }
                } );

    }
}
