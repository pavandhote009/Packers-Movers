package in.project.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private Long bookingId;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	@ManyToOne
	@JoinColumn(name = "provider_id")
	private AgentEntity provider;

	@Column(name = "booking_Date", nullable = false)
	private LocalDate bookingDate; // No @Temporal needed for Java 8+ types
	
	@Column(name = "pickup_Address", nullable = false, length = 255)
	private String pickupAddress;
	
	@Column(name = "drop_Address", nullable = false, length = 255)
	private String dropAddress;
	
	@Column(name = "total_Price", nullable = false)
	private Double totalPrice; // Wrapper class is used to handle null values
	
	public enum BookingStatus { PENDING, CONFIRMED, COMPLETED, CANCELLED }
	@Enumerated(EnumType.STRING)
	@Column(name = "booking_Status", nullable = false)
	private BookingStatus bookingStatus; // Enum type
	
	@Column(name = "payment_Status", nullable = false, length = 255)
	private String paymentStatus;
 

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createDate;

	@UpdateTimestamp
	@Column(name = "updated_at", insertable = false)
	private LocalDateTime updateDate;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public AgentEntity getProvider() {
		return provider;
	}

	public void setProvider(AgentEntity provider) {
		this.provider = provider;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getDropAddress() {
		return dropAddress;
	}

	public void setDropAddress(String dropAddress) {
		this.dropAddress = dropAddress;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}


}