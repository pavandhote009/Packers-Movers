package in.project.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
	private Long agentId;
	
	@Column(name = "name", nullable = false, length = 255)
	private String name;

	@Column(name = "email", nullable = false, length = 255)
	private String email;

	@Column(name = "mobile", nullable = false, length = 255)
	private Double mobile;
	
	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "CompanyName", length = 255)
	private String companyName;

	@Column(name = "experience", nullable = false, length = 255)
	private String experience;

	@Column(name = "serviceCoverage", nullable = false, length = 255)
	private String serviceCoverage;
	
	@Column(name = "pricePerKm", nullable = false, length = 255)
	private String pricePerKm;
	
	@ElementCollection
	@Column(name = "vehicleType", nullable = false, length = 255)
	private List<String> vehicleType;
	
	@Column(name = "numberOfVehicles", nullable = false, length = 255)
	private Integer numberOfVehicles;
	
	@ElementCollection
	@Column(name = "services", nullable = false, length = 255)
	private List<String> services;
	
	

	@Column(name = "address", nullable = false, length = 255)
	private String address;
	
	@Column(name = "state", nullable = false, length = 255)
	private String state;

	@Column(name = "country", nullable = false, length = 255)
	private String country;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createDate;


	@UpdateTimestamp
	@Column(name = "updated_at", insertable = false)
	private LocalDateTime updateDate;
/*
address
availabilityStatus
businessName
city
confirmPassword
country
email
experience
mobile
name
numberOfVehicles
password
pricingModel
serviceCoverage
services

state
vehicleType
: 
[]*/


}