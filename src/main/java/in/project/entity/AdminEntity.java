package in.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class AdminEntity {

	public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long adminid;
	    @Column(name = "name", nullable = false, length = 255)
	    private String name;
	    @Column(name = "email", nullable = false, length = 255)
	    private String email;
	    @Column(name = "password", nullable = false, length = 255)
	    private String password;
	    @Column(name = "role", nullable = false, length = 255)
	    private String role; // "ADMIN" or "USER"

	    // Getters & Setters
	}

}
