package ir.msv.productstore.data.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String serialNumber;
    private int count;
}