package com.ssc.rabbitmq.DelayCommandApp.config;

public class Constant {

    public static final String topicExchangeName = "delayed-topic-exchange";

    public static final String queueName = "delayed-queue";

    public static final String routingKey = "foo.bar.baz";

    public static final int TWO_MINUTS = 2 * 60 * 1000;
}
