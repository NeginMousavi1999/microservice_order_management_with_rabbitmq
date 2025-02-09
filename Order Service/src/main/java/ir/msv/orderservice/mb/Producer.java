package ir.msv.orderservice.mb;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

    @Value("${fanout.exchange}")
    private String fanoutExchange;

    private final RabbitTemplate rabbitTemplate;

    public void produce(String json) {
        rabbitTemplate.setExchange(
                fanoutExchange
        );
        rabbitTemplate.convertAndSend(
                json
        );
    }
}