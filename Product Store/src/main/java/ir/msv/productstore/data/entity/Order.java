package ir.msv.productstore.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Entity
@Table(name = "app_order")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    Date creationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    Product product;

    @Column(nullable = false)
    int count;

    @Column(nullable = false, unique = true)
    String serialNumber;
}