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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "booking")
@SequenceGenerator(name = "prod_seq", sequenceName = "prod_sequence", initialValue = 1000, allocationSize = 1)
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
    @Column(name = "booking_id")
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer; // Corrected relationship

    @ManyToOne
    @JoinColumn(name = "provider_id") // Fixed column name
    private AgentEntity provider; // Corrected relationship

    @Column(name = "booking_date")
    private String bookingDate;
    
    @Column(name = "service")
    private String service;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "drop_address")
    private String dropAddress;

    @Column(name = "details")
    private String details;

    @Column(name = "referance")
    private String referance;
    
    @Column(nullable = false, unique = true)
    private String status; // Example values: PENDING, APPROVED, REJECTED, COMPLETE

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
