package in.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private customerEntity customer;  // Fixed class name casing

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private AgentEntity agent;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "commission_amount", nullable = false)
    private Double commissionAmount;

    @Column(name = "provider_amount", nullable = false)
    private Double providerAmount;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;  // Consider using enum instead

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;  // Modern date/time type

    @Column(name = "transaction_id", unique = true)
    private String transactionId;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "release_status", nullable = false)
    private String releaseStatus;

    @Column(name = "created_at", nullable = false, updatable = false, 
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, 
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}