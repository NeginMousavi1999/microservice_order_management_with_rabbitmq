package ir.msv.productstore.service;

import ir.msv.productstore.data.dto.OrderDTO;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
public interface IOrderService {
    OrderDTO add(OrderDTO orderDTO);
}
