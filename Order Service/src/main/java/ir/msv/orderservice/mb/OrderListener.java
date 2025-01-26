package ir.msv.orderservice.mb;

import ir.msv.orderservice.data.dto.OrderDTO;
import ir.msv.orderservice.service.IOrderService;
import ir.msv.orderservice.utl.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class OrderListener {

    private final IOrderService orderService;

    @RabbitListener(queues = "reply-queue")
    public void receiveMessage(String message) {
        orderService.updateState(
                JsonUtil.fromJson(
                        message,
                        OrderDTO.class
                )
        );
    }
}