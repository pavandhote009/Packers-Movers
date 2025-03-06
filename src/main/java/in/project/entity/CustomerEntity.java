package in.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {  // Class name should be PascalCase
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_Id")  // Explicit column mapping
    private Long customerId;       // Changed to camelCase
 
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "cnfpassword")
    private String cnfpassword;
    
    @Column(name = "mobile", nullable = false)      // Match phone length
    private String mobile;
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createDate;

	@UpdateTimestamp
	@Column(name = "updated_at", insertable = false)
	private LocalDateTime updateDate;


	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", mobile=" + mobile + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}


	
	

}