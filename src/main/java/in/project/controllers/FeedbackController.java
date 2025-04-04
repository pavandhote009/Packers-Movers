package in.project.controllers;

import in.project.entity.CustomerEntity;
import in.project.entity.FeedbackEntity;
import in.project.repository.CustomerRepository;
import in.project.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    
    @Autowired
    private CustomerRepository customerRepository;

    // Create new feedback
    @PostMapping("/save")
    public ResponseEntity<FeedbackEntity> saveFeedback(@RequestBody FeedbackEntity feedback) {
        FeedbackEntity savedFeedback = feedbackService.saveFeedback(feedback);
        return new  ResponseEntity<FeedbackEntity>(HttpStatus.CREATED);
    }

 // Get all feedback
    @GetMapping("/all")
    public ResponseEntity<List<FeedbackEntity>> getAllFeedbacks() {
    	List<CustomerEntity> all = customerRepository.findAll();
        List<FeedbackEntity> feedbackList = feedbackService.getAllFeedback();
        
        if (feedbackList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(feedbackList);
    }

    // Get feedback by ID
    @GetMapping("/{feedbackId}")
    public ResponseEntity<FeedbackEntity> getFeedbackById(@PathVariable Long feedbackId) {
        Optional<FeedbackEntity> feedback = feedbackService.getFeedbackById(feedbackId);
        return feedback.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update feedback
    @PutMapping("/{feedbackId}")
    public ResponseEntity<FeedbackEntity> updateFeedback(
            @PathVariable Long feedbackId, 
            @RequestBody FeedbackEntity feedback) {
        FeedbackEntity updatedFeedback = feedbackService.updateFeedback(feedbackId, feedback);
        if (updatedFeedback != null) {
            return ResponseEntity.ok(updatedFeedback);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete feedback
    @DeleteMapping("/{feedbackId}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long feedbackId) {
        try {
            feedbackService.deletefeedback(feedbackId);
            return ResponseEntity.ok("Feedback deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
