package in.Packers.Movers.Entity;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;

	@ManyToOne
	@JoinColumn(name = "booking_id", nullable = false) // Foreign key for BookingEntity
	private BookingEntity booking;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false) // Foreign key for CustomerEntity
	private customerEntity customer;

	@ManyToOne
	@JoinColumn(name = "agent_id", nullable = false) // Foreign key for AgentEntity
	private AgentEntity agent;

	@Column(name = "total_amount", nullable = false)
	private Double totalAmount;

	@Column(name = "commission_amount", nullable = false)
	private Double commissionAmount;

	@Column(name = "provider_amount", nullable = false)
	private Double providerAmount;

	@Column(name = "payment_status", nullable = false)
	private String paymentStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_date", nullable = false)
	private Date paymentDate;

	@Column(name = "transaction_id", unique = true)
	private String transactionId;

	@Column(name = "payment_method", nullable = false)
	private String paymentMethod;

	@Column(name = "release_status", nullable = false)
	private String releaseStatus;
	
	@Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(name = "updated_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
}