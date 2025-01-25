package ir.msv.orderservice.mb;

import ir.msv.orderservice.exception.AppException;
import ir.msv.orderservice.data.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {

    private final RabbitTemplate rabbitTemplate;
    private final ModelMapper mapper;

    @Value("${queue.name}")
    private String queueName;

    public OrderDTO processMessage() {
        try {
            return mapper.map(
                    rabbitTemplate.receiveAndConvert(queueName),
                    OrderDTO.class
            );
        } catch (IllegalArgumentException e) {
            throw new AppException(
                    "no message found!!!"
            );
        }
    }
}
