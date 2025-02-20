package in.project.services;

import java.util.List;
import java.util.Optional;

import in.project.entity.PaymentEntity;

public interface PaymentService {
	 public PaymentEntity savePayment(PaymentEntity payment);
	   public List<PaymentEntity> getAllPayment();
	   public Optional<PaymentEntity> getpaymentById(Long paymentId);
	   public PaymentEntity updatePayment(Long paymentId, PaymentEntity payment);
	   public void deletePayment(Long paymentId);
}
