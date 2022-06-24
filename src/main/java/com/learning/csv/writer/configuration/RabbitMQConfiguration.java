package com.learning.csv.writer.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String PERSON_QUEUE = "person_queue";
    public static final String INTERACTION_QUEUE = "interaction_queue";
    public static final String EXCHANGE = "direct_exchange";
    public static final String ROUTING_PERSON = "routing_person";
    public static final String ROUTING_INTERACTION = "routing_interaction";

    @Bean
    public Queue personQueue(){
        return new Queue(PERSON_QUEUE);
    }
    @Bean
    public Queue interactionQueue(){
        return new Queue(INTERACTION_QUEUE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingPerson(Queue personQueue, TopicExchange exchange){
        return BindingBuilder.bind(personQueue)
                .to(exchange)
                .with(ROUTING_PERSON);
    }
    @Bean
    public Binding bindingInteraction(Queue interactionQueue, TopicExchange exchange){
        return BindingBuilder.bind(interactionQueue)
                .to(exchange)
                .with(ROUTING_INTERACTION);
    }
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory factory){
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
