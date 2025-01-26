package ir.msv.orderservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    @Value("${fanout.exchange}")
    private String fanoutExchange;

    @Value("${queue.name}")
    private String queueName;

    @Bean
    Queue sendingQueue() {
        return new Queue(
                queueName,
                true
        );
    }

    @Bean
    Queue receivingQueue() {
        return new Queue(
                "reply-queue",
                true
        );
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(
                fanoutExchange
        );
    }

    @Bean
    public Binding bindingSend() {
        return BindingBuilder
                .bind(
                        sendingQueue()
                )
                .to(
                        fanoutExchange()
                );
    }

    @Bean
    public Binding bindingReceive() {
        return BindingBuilder
                .bind(
                        receivingQueue()
                )
                .to(
                        fanoutExchange()
                );
    }
}
