package in.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.FeedbackEntity;
import in.project.repository.FeedbackRepository;
import jakarta.persistence.Column;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackEntity saveFeedback(FeedbackEntity feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public List<FeedbackEntity> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Optional<FeedbackEntity> getFeedbackById(Long feedbackId) {
        return feedbackRepository.findById(feedbackId);
    }

    @Override
    public FeedbackEntity updateFeedback(Long feedbackId, FeedbackEntity feedback) {
        Optional<FeedbackEntity> existingFeedback = feedbackRepository.findById(feedbackId);
        if (existingFeedback.isPresent()) {
            FeedbackEntity updatedFeedback = existingFeedback.get();
            updatedFeedback.setRating(feedback.getRating());
               updatedFeedback.setFeedback(feedback.getFeedback());
               updatedFeedback.setFeedback(feedback.getEmail());
               
            return feedbackRepository.save(updatedFeedback);
        }
        return null;
    }

    @Override
    public void deletefeedback(Long feedbackId) {
        feedbackRepository.deleteById(feedbackId);
    }
}
//private Long feedbackId;       
//private String fullName;
//private String emailId;
//private Integer rating;         // Use wrapper class instead of primitive
//private String comment;