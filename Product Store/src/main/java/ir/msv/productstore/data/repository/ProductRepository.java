package ir.msv.productstore.data.repository;

import ir.msv.productstore.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySerialNumber(String serialNumber);
}
