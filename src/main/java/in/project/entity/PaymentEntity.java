package in.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private CustomerEntity customer;  // Fixed class name casing

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private AgentEntity agent;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount;

    @Column(name = "commission_amount", nullable = false)
    private Double advancePayment;

    @Column(name = "provider_amount", nullable = false)
    private Double remainingPayment;

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

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createDate;

	@UpdateTimestamp
	@Column(name = "updated_at", insertable = false)
	private LocalDateTime updateDate;



}