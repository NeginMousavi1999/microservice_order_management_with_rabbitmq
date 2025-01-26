package ir.msv.orderservice.service.impl;

import ir.msv.orderservice.data.dto.OrderDTO;
import ir.msv.orderservice.data.entity.Order;
import ir.msv.orderservice.data.enumuration.OrderStatus;
import ir.msv.orderservice.data.repository.OrderRepository;
import ir.msv.orderservice.exception.AppException;
import ir.msv.orderservice.mb.Producer;
import ir.msv.orderservice.service.IOrderService;
import ir.msv.orderservice.utl.JsonUtil;
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
    private final OrderRepository repository;

    @Override
    public OrderDTO add(OrderDTO orderDTO) {
        Order order = new Order(
                UUID.randomUUID().toString()
        );
        repository.save(
                order
        );
        orderDTO.setStatus(
                order.getStatus()
        );
        orderDTO.setSerialNumber(
                order.getSerialNumber()
        );
        producer.produce(
                JsonUtil.toJson(
                        orderDTO
                )
        );
        log.info(
                "... successfully add order in queue ..."
        );
        return orderDTO;
    }

    @Override
    public String getStatus(String serialNumber) {
        return getById(
                serialNumber
        )
                .getStatus()
                .getAbbr();
    }

    @Override
    public void updateState(OrderDTO orderDTO) {
        OrderStatus status = orderDTO.getStatus();
        String serialNumber = orderDTO.getSerialNumber();
        log.info(
                "... updating status for '{}' to '{}' ...",
                serialNumber,
                status
        );
        Order order = getById(
                serialNumber
        );
        order.setStatus(
                status
        );
        repository.save(
                order
        );
    }

    private Order getById(String serialNumber) {
        return repository.findById(
                        serialNumber
                )
                .orElseThrow(
                        () -> new AppException("not found")
                );
    }
}