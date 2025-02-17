package in.Packers.Movers.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "agents")
public class AgentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long agent_id;

	@Column(name = "email", nullable = false, length = 255)
	private String email;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	
	@Column(name = "business_Name", nullable = false, length = 255)
	private String businessName;
	
	@Column(name = "service_Model", nullable = false, length = 255)
	private String serviceModel;
	
	@Column(name = "experience", nullable = false, length = 255)
	private String experience;
	
	@Column(name = "availability", nullable = false, length = 255)
	private String availability;
	
	@Column(name = "address", nullable = false, length = 255)
	private String address;
	
	@Column(name = "status", nullable = false, length = 255)
	private String status;
	
	@Column(name = "rating", nullable = false, length = 255)
	private String rating;
	
	@Column(name = "country", nullable = false, length = 255)
	private String country;
	
	@Column(name = "created_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;
	
	@Column(name = "updated_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp updatedAt;
}