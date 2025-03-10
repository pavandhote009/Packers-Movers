package in.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString

@Entity
@Table(name = "AdminTable")
public class AdminEntity {

	
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
		public Long getAdminid() {
			return adminid;
		}
		public void setAdminid(Long adminid) {
			this.adminid = adminid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "User [adminid=" + adminid + ", name=" + name + ", email=" + email + ", password=" + password
					+ ", role=" + role + "]";
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}

	    // Getters & Setters
	

}
