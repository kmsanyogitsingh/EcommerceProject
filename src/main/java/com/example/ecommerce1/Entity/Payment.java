package com.example.ecommerce1.entity;
import java.math.BigDecimal;

import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PaymentDetails")
public class Payment {

    @Id
    private String id;  

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private String productId;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private String vendorId;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false, length = 20)
    private String paymentMode;

    @Column(nullable = false, length = 20)
    private String status;

    @PrePersist
    public void prePersist() {
        if (this.id == null) {  // Avoid overwriting existing IDs
            this.id = "PAY" + UUID.randomUUID().toString().replace("-", "").substring(0, 6);
    }
}
}
