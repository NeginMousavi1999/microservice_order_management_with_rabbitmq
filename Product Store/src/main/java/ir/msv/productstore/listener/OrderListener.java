package ir.msv.productstore.listener;

import com.rabbitmq.client.Channel;
import ir.msv.productstore.data.dto.OrderDTO;
import ir.msv.productstore.service.IOrderService;
import ir.msv.productstore.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class OrderListener implements ChannelAwareMessageListener {

    private final IOrderService orderService;
    private final RabbitTemplate rabbitTemplate;

    @Override
    @RabbitListener(queues = "order_queue", ackMode = "MANUAL")
    public void onMessage(Message message, Channel channel) throws Exception {
        OrderDTO orderDTO = orderService.add(
                JsonUtil.fromJson(
                        new String(
                                message.getBody()
                        ),
                        OrderDTO.class
                )
        );
        Objects.requireNonNull(channel).basicAck(
                message
                        .getMessageProperties()
                        .getDeliveryTag(),
                false
        );
        rabbitTemplate.convertAndSend(
                "reply-queue",
                JsonUtil.toJson(
                        orderDTO
                )
        );
    }
}