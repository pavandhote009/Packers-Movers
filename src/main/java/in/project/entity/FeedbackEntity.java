package in.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "feedback")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")  // Explicit column mapping for snake_case
    private Long feedbackId;        // Correct camelCase naming 

    @Column(name = "email_id", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name= "rating" ,nullable = false, columnDefinition = "INT CHECK (rating BETWEEN 1 AND 5)")
    private Integer rating;         // Use wrapper class instead of primitive

    @Column(name="comment" ,columnDefinition = "TEXT", nullable = false)
    private String feedback;


	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createDate;

	@UpdateTimestamp
	@Column(name = "updated_at", insertable = false)
	private LocalDateTime updateDate;

	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}



	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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

