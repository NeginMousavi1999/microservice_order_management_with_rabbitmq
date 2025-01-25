package ir.msv.productstore.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

/**
 * @author Negin Mousavi 1/25/2025 - Saturday
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreationTimestamp
    Date creationDate;

    @Column(nullable = false)
    String name;

    @Column(nullable = false, unique = true)
    String serialNumber;

    @Column(nullable = false)
    int count;
}