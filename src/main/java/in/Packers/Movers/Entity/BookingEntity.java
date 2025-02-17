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
import lombok.Data;

@Data
@Entity
@Table(name = "booking")
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_Id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private customerEntity customer;

	@ManyToOne
	@JoinColumn(name = "provider_id")
	private AgentEntity provider;

	@Column(name = "booking_Date", nullable = false, length = 255)
	private Date bookingDate;
	
	@Column(name = "pickup_Address", nullable = false, length = 255)
	private String pickupAddress;
	
	@Column(name = "drop_Address", nullable = false, length = 255)
	private String dropAddress;
	
	@Column(name = "total_Price", nullable = false, length = 255)
	private double totalPrice;
	
	@Column(name = "booking_Status", nullable = false, length = 255)
	private String bookingStatus;
	
	@Column(name = "payment_Status", nullable = false, length = 255)
	private String paymentStatus;
 
	@Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(name = "updated_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedAt; 

}