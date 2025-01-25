package ir.msv.productstore.service;

import ir.msv.productstore.data.dto.ProductDTO;
import ir.msv.productstore.data.entity.Product;

import java.util.List;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
public interface IProductService {
    List<ProductDTO> getAll();

    void add(ProductDTO productDTO);

    ProductDTO getBySerialNumber(String serialNumber);

    void deleteBySerialNumber(String serialNumber);

    Product getFullBySerialNumber(String serialNumber);
}
