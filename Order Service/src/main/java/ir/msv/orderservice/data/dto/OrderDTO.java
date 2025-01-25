package ir.msv.orderservice.data.dto;

import ir.msv.orderservice.data.enumuration.OrderStatus;
import lombok.Data;

@Data
public class OrderDTO {
    private String productSerialNumber;
    private int count;
    private String serialNumber;
    private OrderStatus status;
}