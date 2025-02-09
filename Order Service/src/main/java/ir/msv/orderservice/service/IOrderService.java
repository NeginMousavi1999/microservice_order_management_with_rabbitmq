package ir.msv.orderservice.service;

import ir.msv.orderservice.data.dto.OrderDTO;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
public interface IOrderService {
    OrderDTO add(OrderDTO orderDTO);

    String getStatus(String serialNumber);

    void updateState(OrderDTO orderDTO);
}
