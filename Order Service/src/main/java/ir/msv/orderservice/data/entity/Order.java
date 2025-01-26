package ir.msv.orderservice.data.entity;

import ir.msv.orderservice.data.enumuration.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Entity
@Table(name = "order_tracking")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {


    @Column(nullable = false, unique = true)
    @Id
    String serialNumber;

    @CreationTimestamp
    Date creationDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    OrderStatus status;

    public Order(String serialNumber) {
        this.serialNumber = serialNumber;
        this.status = OrderStatus.WAITING_FOR_REGISTRATION;
    }
}