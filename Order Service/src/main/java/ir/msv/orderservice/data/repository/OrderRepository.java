package ir.msv.orderservice.data.repository;

import ir.msv.orderservice.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Negin Mousavi - 1/26/2025, Sunday
 **/
public interface OrderRepository extends JpaRepository<Order, String> {
}
