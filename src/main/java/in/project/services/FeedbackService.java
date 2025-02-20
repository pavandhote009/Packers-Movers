package in.project.services;

import java.util.List;
import java.util.Optional;

import in.project.entity.FeedbackEntity;

public interface FeedbackService {
	 public FeedbackEntity saveFeedback(FeedbackEntity feedback);
	   public List<FeedbackEntity> getAllFeedback();
	   public Optional<FeedbackEntity> getFeedbackById(Long feedbackId);
	   public FeedbackEntity updateFeedback(Long feedbackId, FeedbackEntity feedback);
	   public void deletefeedback(Long feedbackId);
}
