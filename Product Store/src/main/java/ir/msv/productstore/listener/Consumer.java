package ir.msv.productstore.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${queue.name}")
    private String queueName;

    public String consume() {
        return (String) rabbitTemplate.receiveAndConvert(queueName);
    }
}
