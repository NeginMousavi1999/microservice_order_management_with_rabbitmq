package ir.msv.productstore.data.repository;

import ir.msv.productstore.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Repository
    public interface OrderRepository extends JpaRepository<Order, Long> {
}
