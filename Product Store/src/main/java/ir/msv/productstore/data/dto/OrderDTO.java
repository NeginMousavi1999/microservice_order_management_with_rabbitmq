package ir.msv.productstore.data.dto;

import ir.msv.productstore.enumuration.OrderStatus;
import lombok.Data;

@Data
public class OrderDTO {
    private String productSerialNumber;
    private int count;
    private String serialNumber;
    private OrderStatus status;
}