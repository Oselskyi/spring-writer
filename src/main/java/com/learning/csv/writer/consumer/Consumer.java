package com.learning.csv.writer.consumer;

import com.learning.csv.writer.entiy.Interaction;
import com.learning.csv.writer.entiy.Person;
import com.learning.csv.writer.service.Converter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.learning.csv.writer.configuration.RabbitMQConfiguration.INTERACTION_QUEUE;
import static com.learning.csv.writer.configuration.RabbitMQConfiguration.PERSON_QUEUE;

@Component
public class Consumer {

    private final Converter converter;

    public Consumer(Converter converter) {
        this.converter = converter;
    }

    @RabbitListener(queues = PERSON_QUEUE)
    public void consumeMessageFromPersonQueue(Person obj) {
        converter.convert(obj);
    }

    @RabbitListener(queues =  INTERACTION_QUEUE)
    public void consumeMessageFromInteractionQueue(Interaction obj) {
            converter.convert(obj);
    }

}
