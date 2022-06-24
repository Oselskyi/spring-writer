package com.learning.csv.writer.publisher;

import com.learning.csv.writer.entiy.Interaction;
import com.learning.csv.writer.entiy.Person;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import static com.learning.csv.writer.configuration.RabbitMQConfiguration.*;

@RestController
@RequestMapping("/send")
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/person/{amount}")
    public String publishPerson(@PathVariable int amount){

        Person max ;

        for (int i = 0; i < amount; i++) {
            max = new Person(i, "Max" , "Best",i * 2);
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_PERSON, max);
        }
        return "Success !!!";
    }

    @PostMapping("/inter/{amount}")
    public String publishInteraction(@PathVariable int amount){

        Interaction interaction;

        for (int i = 0; i < amount; i++) {
            interaction = new Interaction("3", Time.valueOf(LocalTime.now().minusHours(8)),
                    Time.valueOf(LocalTime.now().minusHours(2)),
                    "users/source/java", "Dell", List.of("7", "8", "9"));
            rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_INTERACTION, interaction);
        }
        return "Success !!!";
    }
}
