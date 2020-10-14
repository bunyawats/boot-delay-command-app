package com.ssc.rabbitmq.DelayCommandApp.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Bean
    Queue queue() {
        return new Queue ( Constant.queueName, false );
    }

    @Bean
    DirectExchange exchange() {

        DirectExchange exchange = new DirectExchange ( Constant.topicExchangeName );
        exchange.setDelayed ( true );

        return exchange;
    }

    @Bean
    Binding binding(Queue queue, Exchange exchange) {
        return BindingBuilder.bind ( queue )
                .to ( exchange )
                .with ( Constant.routingKey )
                .noargs ( );
    }



}
