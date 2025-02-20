package in.project.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.project.entity.AgentEntity;
import in.project.entity.BookingEntity;
import in.project.entity.CustomerEntity;
import in.project.entity.PaymentEntity;
import in.project.repository.PaymentRepository;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentEntity savePayment(PaymentEntity payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public List<PaymentEntity> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<PaymentEntity> getpaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public PaymentEntity updatePayment(Long paymentId, PaymentEntity payment) {
        Optional<PaymentEntity> existingPayment = paymentRepository.findById(paymentId);
        if (existingPayment.isPresent()) {
            PaymentEntity updatedPayment = existingPayment.get();
            updatedPayment.setBooking(payment.getBooking());
            updatedPayment.setCustomer(payment.getCustomer());
            updatedPayment.setAgent(payment.getAgent());
            updatedPayment.setTotalAmount(payment.getTotalAmount());
            updatedPayment.setCommissionAmount(payment.getCommissionAmount());
            updatedPayment.setProviderAmount(payment.getProviderAmount());
            updatedPayment.setPaymentStatus(payment.getPaymentStatus());
            updatedPayment.setPaymentDate(payment.getPaymentDate());
            updatedPayment.setTransactionId(payment.getTransactionId());
            updatedPayment.setPaymentMethod(payment.getPaymentMethod());
            updatedPayment.setReleaseStatus(payment.getReleaseStatus());
            return paymentRepository.save(updatedPayment);
        }
        return null;
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
//private Long paymentId;
//private BookingEntity booking;
//private CustomerEntity customer;
//private AgentEntity agent;
//private Double totalAmount;
//private Double commissionAmount;
//private Double providerAmount;
//private String paymentStatus; 
//private LocalDateTime paymentDate; 
//private String transactionId;
//private String paymentMethod;
//private String releaseStatus;

