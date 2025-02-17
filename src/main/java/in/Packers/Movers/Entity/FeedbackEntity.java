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
@Table(name = "feedback")
public class FeedbackEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long feedbackid;

	@Column(name = "full_name", nullable = false, length = 255)
	private String fullName;

	@Column(name = "email_id", nullable = false, unique = true, length = 255)
	private String emailId;

	@Column(nullable = false, columnDefinition = "INT CHECK (rating BETWEEN 1 AND 5)")
	private int rating;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String comment;

	@Column(name = "submitted_at", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp submittedAt;
}