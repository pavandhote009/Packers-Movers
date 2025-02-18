package in.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class customerEntity {  // Class name should be PascalCase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id")  // Explicit column mapping
    private Long customerId;       // Changed to camelCase
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;
    
    @Column(name = "address", nullable = false, length = 255)
    private String address;
 
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
    @Column(name = "first_Name", nullable = false, length = 50)  // Reduced length
    private String firstName;
    
    @Column(name = "last_Name", nullable = false, length = 50)   // Reduced length
    private String lastName;
    
    @Column(name = "date_Of_Birth", nullable = false)
    private LocalDate dateOfBirth;  // Correct for DATE type
    
    @Column(name = "mobile", nullable = false, length = 15)      // Match phone length
    private String mobile;
    
    @Column(name = "nationality", nullable = false, length = 50)
    private String nationality;
    
    @Column(name = "full_Address", nullable = false, length = 255)
    private String fullAddress;
    
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    
    @Column(name = "state", nullable = false, length = 50)
    private String state;
    
    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}