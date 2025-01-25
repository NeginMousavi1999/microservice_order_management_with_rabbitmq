package ir.msv.productstore.service.impl;

import ir.msv.productstore.data.dto.OrderDTO;
import ir.msv.productstore.data.entity.Order;
import ir.msv.productstore.data.entity.Product;
import ir.msv.productstore.data.repository.OrderRepository;
import ir.msv.productstore.exception.AppException;
import ir.msv.productstore.service.IOrderService;
import ir.msv.productstore.service.IProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final IProductService productService;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void add(OrderDTO orderDTO) {
        int count = orderDTO.getCount();
        Product product;
        try {
            product = productService.getFullBySerialNumber(
                    orderDTO.getProductSerialNumber()
            );
        } catch (AppException e) {
            rejectOrder(
                    orderDTO
            );
            return;
        }
        int productCount = product.getCount();
        if (productCount >= count) {
            product.setCount(
                    productCount - count
            );
            orderRepository.save(
                    Order.builder()
                            .count(count)
                            .serialNumber(
                                    orderDTO.getSerialNumber()
                            )
                            .product(
                                    product
                            )
                            .build()
            );
        } else {
            rejectOrder(
                    orderDTO
            );
        }
    }

    private void rejectOrder(OrderDTO orderDTO) {

    }
}