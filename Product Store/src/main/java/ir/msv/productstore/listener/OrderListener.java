package ir.msv.productstore.listener;

import ir.msv.productstore.data.dto.OrderDTO;
import ir.msv.productstore.service.IOrderService;
import ir.msv.productstore.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class OrderListener {
    private final Consumer orderConsumer;
    private final IOrderService orderService;

    @Scheduled(cron = "0 * * * * *")
    public void receiveOrders() {
        String json = orderConsumer.consume();
        if (json == null) {
            log.debug("... no order ...");
        } else {
            orderService.add(
                    JsonUtil.fromJson(
                            json,
                            OrderDTO.class
                    )
            );
        }
    }
}
