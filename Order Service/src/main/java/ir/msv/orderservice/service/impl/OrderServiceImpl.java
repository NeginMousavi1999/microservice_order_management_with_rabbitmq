package ir.msv.orderservice.service.impl;

import ir.msv.orderservice.utl.JsonUtil;
import ir.msv.orderservice.data.dto.OrderDTO;
import ir.msv.orderservice.data.enumuration.OrderStatus;
import ir.msv.orderservice.mb.Producer;
import ir.msv.orderservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final Producer producer;

    @Override
    public OrderDTO add(OrderDTO orderDTO) {
        orderDTO.setStatus(
                OrderStatus.WAITING_FOR_REGISTRATION
        );
        orderDTO.setSerialNumber(
                UUID.randomUUID().toString()
        );
        producer.produce(
                JsonUtil.toJson(
                        orderDTO
                )
        );
        return orderDTO;
    }

    @Override
    public OrderDTO getBySerialNumber(String serialNumber) {
        return null;
        // todo...
    }
}