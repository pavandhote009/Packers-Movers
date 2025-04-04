package in.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "quotation")
public class QuotationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "quotation_id")
	private Long quotationId;

	// Customer & Agent References
	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private CustomerEntity customer;

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false)
	private AgentEntity agent;

//	// Payment Reference
//	@OneToOne
//	@JoinColumn(name = "payment_id", nullable = false)
//	private PaymentEntity payment;

	
	// Service Details
	@Column(name = "service", nullable = false, length = 255)
	private String service;

	@Column(name = "distance_in_km", nullable = false)
	private Double distanceInKm;

	@Column(name = "price_per_km", nullable = false)
	private Double pricePerKm;

	@Column(name = "total_price", nullable = false)
	private Double totalPrice;

	@Column(name = "tax_amount")
	private Double taxAmount;



	@Column(name = "final_amount", nullable = false)
	private Double finalAmount;

	// Pickup & Drop Details
	@Column(name = "pickup_address", nullable = false, length = 500)
	private String pickupAddress;

	@Column(name = "drop_address", nullable = false, length = 500)
	private String dropAddress;
//
//	@Column(name = "transaction_id", unique = true)
//	private String transactionId;

//	// Quotation metadata
//	@CreationTimestamp
//	@Column(name = "quotation_date", nullable = false)
//	private LocalDateTime quotationDate;
//
//	@Column(name = "status", nullable = false)
//	private String status; // PENDING, APPROVED, REJECTED, EXPIRED
}