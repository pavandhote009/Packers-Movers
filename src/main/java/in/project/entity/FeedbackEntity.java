package in.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "feedback")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")  // Explicit column mapping for snake_case
    private Long feedbackId;        // Correct camelCase naming

    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    @Column(name = "email_id", nullable = false, unique = true, length = 255)
    private String emailId;

    @Column(nullable = false, columnDefinition = "INT CHECK (rating BETWEEN 1 AND 5)")
    private Integer rating;         // Use wrapper class instead of primitive

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @Column(name = "submitted_at", nullable = false, updatable = false, insertable = false, 
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime submittedAt;  // Modern date/time type
}