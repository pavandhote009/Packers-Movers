package in.project.controllers;

import in.project.entity.PaymentEntity;
import in.project.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // Create new payment
    @PostMapping("/data")
    public ResponseEntity<PaymentEntity> savePayment(@RequestBody PaymentEntity payment) {
        PaymentEntity savedPayment = paymentService.savePayment(payment);
        return ResponseEntity.ok(savedPayment);
    }

    // Get all payments
    @GetMapping("/")
    public ResponseEntity<List<PaymentEntity>> getAllPayments() {
        List<PaymentEntity> payments = paymentService.getAllPayment();
        return ResponseEntity.ok(payments);
    }

    // Get payment by ID
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentEntity> getPaymentById(@PathVariable Long paymentId) {
        Optional<PaymentEntity> payment = paymentService.getpaymentById(paymentId);
        return payment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update payment
    @PutMapping("/{paymentId}")
    public ResponseEntity<PaymentEntity> updatePayment(
            @PathVariable Long paymentId, 
            @RequestBody PaymentEntity payment) {
        PaymentEntity updatedPayment = paymentService.updatePayment(paymentId, payment);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete payment
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable Long paymentId) {
        try {
            paymentService.deletePayment(paymentId);
            return ResponseEntity.ok("Payment deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
